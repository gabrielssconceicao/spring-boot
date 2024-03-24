package com.algaworks.awpag.awpagapi.api.controller;

import java.util.List;
import java.util.Optional;


import com.algaworks.awpag.awpagapi.domain.repositoriy.IClientRepository;
import com.algaworks.awpag.awpagapi.domain.service.ClientService;
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

    private final ClientService clientService;
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
        return clientService.save(client);
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
        client = clientService.save(client);
        return  ResponseEntity.ok(client);
    }


    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId){
        if(!clientRepository.existsById(clientId)) {
            return  ResponseEntity.notFound().build();
        }
        clientService.delete(clientId);
        return ResponseEntity.noContent().build();
    }


}
