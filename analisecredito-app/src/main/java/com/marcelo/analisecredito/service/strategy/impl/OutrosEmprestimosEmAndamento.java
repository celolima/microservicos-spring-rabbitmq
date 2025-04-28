package com.marcelo.analisecredito.service.strategy.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.marcelo.analisecredito.domain.Proposta;
import com.marcelo.analisecredito.service.strategy.CalculoPonto;

@Component
public class OutrosEmprestimosEmAndamento implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
       return isEmprestimosEmAndamento() ? 0 : 80;
    }

    /**
     * Simula acesso ao BACEN
     * @return
     */
    private boolean isEmprestimosEmAndamento() {
        return new Random().nextBoolean();
    }


}
