package com.algaworks.awpag.awpagapi.domain.service;

import com.algaworks.awpag.awpagapi.domain.exception.BusinessException;
import com.algaworks.awpag.awpagapi.domain.model.Client;
import com.algaworks.awpag.awpagapi.domain.model.Parcelamento;
import com.algaworks.awpag.awpagapi.domain.repositoriy.IParcelamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class ParcelamentoService {

    private  final IParcelamentoRepository parcelamentoRepository;
    private  final ClientService clientService;

    public Parcelamento create(Parcelamento novoParcelamento) {
        if (novoParcelamento.getId() != null) {
           throw new BusinessException("Parcelamento criado não deve posssuir um codigo");
        }

        Client client = clientService.search(novoParcelamento.getClient().getId());


        novoParcelamento.setCreationDate(OffsetDateTime.now());
        novoParcelamento.setClient(client);
        return parcelamentoRepository.save(novoParcelamento);
    }
}
