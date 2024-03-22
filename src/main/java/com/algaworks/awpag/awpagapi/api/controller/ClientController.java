package com.algaworks.awpag.awpagapi.api.controller;

import java.util.List;

import com.algaworks.awpag.awpagapi.domain.repositoriy.IClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.awpag.awpagapi.domain.model.Client;

@AllArgsConstructor
@RestController
public class ClientController {

    // @Autowired -> aplica uma instancia de IClientRepository

    private final IClientRepository clientRepository;



    @GetMapping("/clients")
  public List<Client> list() {
      return clientRepository.findAll();
  }
}
