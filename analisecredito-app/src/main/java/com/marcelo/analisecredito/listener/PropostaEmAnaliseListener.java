package com.marcelo.analisecredito.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.marcelo.analisecredito.domain.Proposta;

@Component
public class PropostaEmAnaliseListener {

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaEmAnaliseListener(Proposta proposta) {
    }

}
