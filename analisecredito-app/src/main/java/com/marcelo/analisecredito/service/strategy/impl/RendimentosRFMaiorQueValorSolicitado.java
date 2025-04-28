package com.marcelo.analisecredito.service.strategy.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.marcelo.analisecredito.domain.Proposta;
import com.marcelo.analisecredito.service.strategy.CalculoPonto;

@Component
public class RendimentosRFMaiorQueValorSolicitado implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
       return isEmprestimoMaiorQueRendimentos(proposta.getValorSolicitado()) ? 0 : 80;
    }

    /**
     * Simula acesso à Receita Federal para acesso aos Rendimentos
     * @return
     */
    private boolean isEmprestimoMaiorQueRendimentos(double valorEmprestimo) {
        double valorRendimentos = new Random().nextDouble();
        return valorEmprestimo > valorRendimentos;
    }


}
