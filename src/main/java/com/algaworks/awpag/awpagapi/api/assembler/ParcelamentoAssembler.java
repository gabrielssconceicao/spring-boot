package com.algaworks.awpag.awpagapi.api.assembler;

import com.algaworks.awpag.awpagapi.api.model.output.ParcelamentoModel;
import com.algaworks.awpag.awpagapi.domain.model.Parcelamento;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ParcelamentoAssembler {

    private final ModelMapper modelMapper;

    public ParcelamentoModel toModel(Parcelamento parcelamento) {
        return modelMapper.map(parcelamento, ParcelamentoModel.class);
    }

    public List<ParcelamentoModel> toCollectionModel(List<Parcelamento> parcelamentos) {
        return parcelamentos
                .stream()
                .map(this::toModel)
                .toList();
    }
}
