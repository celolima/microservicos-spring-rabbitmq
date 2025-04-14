package com.pieropan.propostaapp.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.pieropan.propostaapp.dto.PropostaResponseDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NotificacaoService {

    private RabbitTemplate rabbitTemplate;

    public void notificar(PropostaResponseDTO responseDTO, String exchangeName) {
        this.rabbitTemplate.convertAndSend(exchangeName,"",responseDTO);
    }
}