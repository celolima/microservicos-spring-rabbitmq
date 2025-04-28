package com.marcelo.analisecredito.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Proposta {

    private Long id;
    private Double valorSolicitado;
    private Integer prazoPagamento;
    private Boolean aprovada;
    private String observacao;
    private Usuario usuario;
}
