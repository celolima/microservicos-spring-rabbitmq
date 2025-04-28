package com.marcelo.propostaapp.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcelo.propostaapp.entity.Proposta;
import com.marcelo.propostaapp.repository.PropostaRepository;

@Component
public class PropostaConcluidaListener {

    @Autowired
    private PropostaRepository propostaRepository;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaPendenteListener(Proposta proposta) {
        propostaRepository.save(proposta);
    }

}
