package com.marcelo.analisecredito.service.strategy.impl;

import java.util.Random;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.marcelo.analisecredito.constants.MessageConstant;
import com.marcelo.analisecredito.domain.Proposta;
import com.marcelo.analisecredito.exceptions.StrategyException;
import com.marcelo.analisecredito.service.strategy.CalculoPonto;

@Order(2)
@Component
public class PontuacaoScoreImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return switch (score()) {            
            case Integer s when s <= 200 -> throw new StrategyException(String.format(MessageConstant.PONTUACAO_SERASA_BAIXA, proposta.getUsuario().getNome()));
            case Integer s when s <= 400 -> 150;
            case Integer s when s <= 600 -> 180;
            default -> 220;
        };        
    }

    /**
     * Simula acesso ao Score do Serasa
     * @return
     */
    private Integer score() {
        return new Random().nextInt(0,1000);
    }

}
