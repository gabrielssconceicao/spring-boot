package com.algaworks.awpag.awpagapi.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class ParcelamentoModel {

    private Long id;
    //private String clientName;
    private ClientResumoModel client;
    private String description;
    private BigDecimal amount;
    private  Integer parcelas;
    private OffsetDateTime creationDate;
}
