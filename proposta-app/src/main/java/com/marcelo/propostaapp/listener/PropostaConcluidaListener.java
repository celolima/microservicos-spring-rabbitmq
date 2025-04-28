package com.marcelo.propostaapp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcelo.propostaapp.entity.Proposta;
import com.marcelo.propostaapp.repository.PropostaRepository;

@Component
public class PropostaConcluidaListener {

    private final Logger logger = LoggerFactory.getLogger(PropostaConcluidaListener.class);

    @Autowired
    private PropostaRepository propostaRepository;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluidaListener(Proposta proposta) {
        logger.info("Proposta concluída!");
        propostaRepository.atualizarProposta(proposta.getId(), proposta.getAprovada(), proposta.getObservacao());
    }

}
