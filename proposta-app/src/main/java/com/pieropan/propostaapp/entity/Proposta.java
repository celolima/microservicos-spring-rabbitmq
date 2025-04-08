package com.pieropan.propostaapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "TB_PROPOSTA")
@Entity
@Getter
@Setter
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorSolicitado;
    private Integer prazoPagamento;
    private Boolean aprovado;
    private Boolean integrada;
    private String observacao;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}

