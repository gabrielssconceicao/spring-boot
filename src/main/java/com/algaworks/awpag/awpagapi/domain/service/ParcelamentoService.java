package com.algaworks.awpag.awpagapi.domain.service;

import com.algaworks.awpag.awpagapi.domain.model.Parcelamento;
import com.algaworks.awpag.awpagapi.domain.repositoriy.IParcelamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ParcelamentoService {

    private  final IParcelamentoRepository parcelamentoRepository;

    public Parcelamento create(Parcelamento novoParcelamento) {
        novoParcelamento.setCreationDate(LocalDate.from(LocalDateTime.now()));

        return parcelamentoRepository.save(novoParcelamento);
    }
}
