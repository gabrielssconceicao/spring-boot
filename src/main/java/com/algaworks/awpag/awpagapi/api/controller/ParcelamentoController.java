package com.algaworks.awpag.awpagapi.api.controller;


import com.algaworks.awpag.awpagapi.domain.exception.BusinessException;
import com.algaworks.awpag.awpagapi.domain.model.Parcelamento;
import com.algaworks.awpag.awpagapi.domain.repositoriy.IParcelamentoRepository;
import com.algaworks.awpag.awpagapi.domain.service.ParcelamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/parcelamentos")
public class ParcelamentoController {
    private final IParcelamentoRepository parcelamentoRepository;
    private final ParcelamentoService parcelamentoService;

    @GetMapping
    public List<Parcelamento> list() {
        return parcelamentoRepository.findAll();
    }

    @GetMapping("/{parcelamentoId}")
    public ResponseEntity<Parcelamento> search(@PathVariable Long parcelamentoId) {
        return parcelamentoRepository.findById(parcelamentoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parcelamento create(@RequestBody Parcelamento parcelamento) {
        return parcelamentoService.create(parcelamento);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> capture(BusinessException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
