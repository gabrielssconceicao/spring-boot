package com.algaworks.awpag.awpagapi.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.awpag.awpagapi.domain.model.Client;

@RestController
public class ClientController {
  @GetMapping("/clients")
  public List<Client> list() {
    Client client1 = new Client();
    client1.setId(1);
    client1.setName("John Doe");
    client1.setEmail("jdoe@ex.com");
    client1.setTelephone("(11) 99999-9999");
    Client client2 = new Client();
    client2.setId(2);
    client2.setName("Mary Doe");
    client2.setEmail("mdoe@ex.com");
    client2.setTelephone("(41) 5353-9999");

    return Arrays.asList(client1, client2);
  }
}
