package com.algaworks.awpag.awpagapi.api.controller;

import java.util.List;
import java.util.Optional;

import com.algaworks.awpag.awpagapi.domain.exception.BusinessException;
import com.algaworks.awpag.awpagapi.domain.repositoriy.IClientRepository;
import com.algaworks.awpag.awpagapi.domain.service.ClientRegistrationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.algaworks.awpag.awpagapi.domain.model.Client;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRegistrationService clientRegistrationService;
    private final IClientRepository clientRepository;

    @GetMapping
    public List<Client> list() {
      return clientRepository.findAll();
    }


    @GetMapping("/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        if(client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }

        return ResponseEntity.notFound().build();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Client create(@Valid @RequestBody Client client) {
        return clientRegistrationService.save(client);
    }


    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(
            @PathVariable Long clientId,
            @Valid @RequestBody Client client
    ) {
        if(!clientRepository.existsById(clientId)) {
            return  ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        client = clientRegistrationService.save(client);
        return  ResponseEntity.ok(client);
    }


    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId){
        if(!clientRepository.existsById(clientId)) {
            return  ResponseEntity.notFound().build();
        }
        clientRegistrationService.delete(clientId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> capture(BusinessException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
