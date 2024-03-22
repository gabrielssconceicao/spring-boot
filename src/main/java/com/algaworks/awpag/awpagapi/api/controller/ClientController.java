package com.algaworks.awpag.awpagapi.api.controller;

import java.util.List;
import java.util.Optional;

import com.algaworks.awpag.awpagapi.domain.repositoriy.IClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.algaworks.awpag.awpagapi.domain.model.Client;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    // @Autowired -> aplica uma instancia de IClientRepository

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
    public Client create(@RequestBody Client client) {
        return clientRepository.save(client);
    }
}
