package com.marcelo.analisecredito.service.strategy.impl;

import java.util.Random;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.marcelo.analisecredito.constants.MessageConstant;
import com.marcelo.analisecredito.domain.Proposta;
import com.marcelo.analisecredito.exceptions.StrategyException;
import com.marcelo.analisecredito.service.strategy.CalculoPonto;

@Order(1)
@Component
public class NomeNegativadoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        if(nomeNegativado()) {
            throw new StrategyException(String.format(MessageConstant.CLIENTE_NEGATIVADO, proposta.getUsuario().getNome()));
        }

        return 100;
    }

    private boolean nomeNegativado() {
        return new Random().nextBoolean();
    }

}
