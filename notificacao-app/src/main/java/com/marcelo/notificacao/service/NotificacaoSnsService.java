package com.marcelo.notificacao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoSnsService {

    private final Logger logger = LoggerFactory.getLogger(NotificacaoSnsService.class);

    public void notificar(String message) {
        logger.info("Sending message to user");
        logger.info(message);
    }
}
