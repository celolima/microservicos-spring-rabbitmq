package com.marcelo.analisecredito.service.strategy;

import com.marcelo.analisecredito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}
