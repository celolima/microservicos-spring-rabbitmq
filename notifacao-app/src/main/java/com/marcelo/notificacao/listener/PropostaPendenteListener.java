package com.marcelo.notificacao.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcelo.notificacao.constants.MessagemConstant;
import com.marcelo.notificacao.domain.Proposta;
import com.marcelo.notificacao.service.NotificacaoSnsService;

@Component
public class PropostaPendenteListener {

    @Autowired
    private NotificacaoSnsService notificacaoSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaPendenteListener(Proposta proposta) {
        String message = String.format(MessagemConstant.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        notificacaoSnsService.notificar(message);
    }

}
