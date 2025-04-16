package com.marcelo.notificacao.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proposta {

    private Long id;
    private Double valorSolicitado;
    private Integer prazoPagamento;
    private Boolean aprovada;
    private Boolean integrada;
    private String observacao;
    private Usuario usuario;

}
