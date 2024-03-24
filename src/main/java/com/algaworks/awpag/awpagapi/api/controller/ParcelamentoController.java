package com.algaworks.awpag.awpagapi.api.controller;



import com.algaworks.awpag.awpagapi.api.model.ParcelamentoModel;
import com.algaworks.awpag.awpagapi.domain.model.Parcelamento;
import com.algaworks.awpag.awpagapi.domain.repositoriy.IParcelamentoRepository;
import com.algaworks.awpag.awpagapi.domain.service.ParcelamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @GetMapping
    public List<Parcelamento> list() {
        return parcelamentoRepository.findAll();
    }

    @GetMapping("/{parcelamentoId}")
    public ResponseEntity<ParcelamentoModel> search(@PathVariable Long parcelamentoId) {
        return parcelamentoRepository
                .findById(parcelamentoId)

                .map(parcelamento -> {
                    var parcelamentoModel = modelMapper.map(parcelamento,ParcelamentoModel.class);
                    return parcelamentoModel;
                })

                .map(ResponseEntity::ok)

                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parcelamento create(@Valid @RequestBody Parcelamento parcelamento) {
        return parcelamentoService.create(parcelamento);
    }

}
