package com.pieropan.propostaapp.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.pieropan.propostaapp.entity.Proposta;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NotificacaoRabbitMQService {

    private RabbitTemplate rabbitTemplate;

    public void notificar(Proposta proposta, String exchangeName) {
        this.rabbitTemplate.convertAndSend(exchangeName,"",proposta);
    }
}