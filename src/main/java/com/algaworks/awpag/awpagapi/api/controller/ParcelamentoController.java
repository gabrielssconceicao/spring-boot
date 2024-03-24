package com.algaworks.awpag.awpagapi.api.controller;



import com.algaworks.awpag.awpagapi.api.assembler.ParcelamentoAssembler;
import com.algaworks.awpag.awpagapi.api.model.output.ParcelamentoModel;
import com.algaworks.awpag.awpagapi.domain.model.Parcelamento;
import com.algaworks.awpag.awpagapi.domain.repositoriy.IParcelamentoRepository;
import com.algaworks.awpag.awpagapi.domain.service.ParcelamentoService;
import jakarta.validation.Valid;
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
    private final ParcelamentoAssembler parcelamentoAssembler;

    @GetMapping
    public List<ParcelamentoModel> list() {
        return parcelamentoAssembler.toCollectionModel( parcelamentoRepository.findAll());
    }

    @GetMapping("/{parcelamentoId}")
    public ResponseEntity<ParcelamentoModel> search(@PathVariable Long parcelamentoId) {
        return parcelamentoRepository
                .findById(parcelamentoId)
                .map(parcelamentoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParcelamentoModel create(@Valid @RequestBody Parcelamento parcelamento) {
        Parcelamento parcelamentoCadastrado= parcelamentoService.create(parcelamento);
        return parcelamentoAssembler.toModel(parcelamentoCadastrado);
    }

}
