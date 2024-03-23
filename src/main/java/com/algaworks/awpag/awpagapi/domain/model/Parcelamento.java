package com.algaworks.awpag.awpagapi.domain.model;

import com.algaworks.awpag.awpagapi.domain.validation.IValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcelamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    // @JoinColumn(name = "client_id")
    @Valid
    @ConvertGroup(from = Default.class, to= IValidationGroups.ClientId.class)
    @NotNull
    @ManyToOne
    private  Client client;

    @NotBlank
    @Size(max = 20)
    private String descriptions;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    @Positive
    @Max(12)
    @Column(name = "qtd_parcelas")
    private Integer qtdParcelas;

    @Column(name = "creation_date")
    private LocalDate creationDate;

}
