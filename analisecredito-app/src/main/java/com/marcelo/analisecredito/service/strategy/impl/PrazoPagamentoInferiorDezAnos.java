package com.marcelo.analisecredito.service.strategy.impl;

import org.springframework.stereotype.Component;

import com.marcelo.analisecredito.domain.Proposta;
import com.marcelo.analisecredito.service.strategy.CalculoPonto;

@Component
public class PrazoPagamentoInferiorDezAnos implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
       return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }

}
