package com.algaworks.awpag.awpagapi.domain.model;

import jakarta.persistence.*;
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



    @ManyToOne
    // @JoinColumn(name = "client_id")
    private  Client client;

    private String descriptions;

    private BigDecimal amount;

    @Column(name = "qtd_parcelas")
    private Integer qtdParcelas;

    @Column(name = "creation_date")
    private LocalDate creationDate;

}
