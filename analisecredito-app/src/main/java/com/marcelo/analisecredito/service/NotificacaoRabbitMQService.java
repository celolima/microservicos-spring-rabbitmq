package com.marcelo.analisecredito.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.analisecredito.domain.Proposta;

@Service
public class NotificacaoRabbitMQService {

    private final Logger logger = LoggerFactory.getLogger(NotificacaoRabbitMQService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notificar(String exchange, Proposta proposta) {        
        rabbitTemplate.convertAndSend(exchange, "", proposta);
        logger.info("Análise de credito finalizada");
    }

}
