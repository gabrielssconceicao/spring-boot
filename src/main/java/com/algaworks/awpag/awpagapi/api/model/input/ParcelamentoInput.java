package com.algaworks.awpag.awpagapi.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ParcelamentoInput {

    @NotBlank
    @Size(max = 20)
    private String descriptions;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    @Positive
    @Max(12)
    private Integer qtdParcelas;

    @Valid
    @NotNull
    private ClientIdInput clientId;
}
