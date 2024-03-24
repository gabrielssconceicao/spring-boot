package com.algaworks.awpag.awpagapi.api.controller;



import com.algaworks.awpag.awpagapi.api.model.ParcelamentoModel;
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

    @GetMapping
    public List<Parcelamento> list() {
        return parcelamentoRepository.findAll();
    }

    @GetMapping("/{parcelamentoId}")
    public ResponseEntity<ParcelamentoModel> search(@PathVariable Long parcelamentoId) {
        return parcelamentoRepository.findById(parcelamentoId)
                .map(parcelamento -> {
                    var parcelamentoModel = new ParcelamentoModel();
                    parcelamentoModel.setId(parcelamento.getId());
                    parcelamentoModel.setClientName(parcelamento.getClient().getName());
                    parcelamentoModel.setDescription(parcelamento.getDescriptions());
                    parcelamentoModel.setAmount(parcelamento.getAmount());
                    parcelamentoModel.setParcelas(parcelamento.getQtdParcelas());
                    parcelamentoModel.setCreationDate(parcelamento.getCreationDate());
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
