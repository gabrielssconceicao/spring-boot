package com.algaworks.awpag.awpagapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
  @GetMapping("/clients")
  public String list() {
    return "Testing Route";
  }
}
