package com.algaworks.awpag.awpagapi.api.controller;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.awpag.awpagapi.domain.model.Client;

@RestController
public class ClientController {
  @PersistenceContext
  private EntityManager manager;
  @GetMapping("/clients")
  public List<Client> list() {
    return  manager
            .createQuery("from Client", Client.class)
            .getResultList();
  }
}
