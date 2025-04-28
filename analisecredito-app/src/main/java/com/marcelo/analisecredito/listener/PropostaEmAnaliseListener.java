package com.marcelo.analisecredito.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcelo.analisecredito.domain.Proposta;
import com.marcelo.analisecredito.service.AnaliseCreditoService;

@Component
public class PropostaEmAnaliseListener {

    @Autowired
    private AnaliseCreditoService analiseCreditoService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaEmAnaliseListener(Proposta proposta) {
        analiseCreditoService.analisar(proposta);
    }

}