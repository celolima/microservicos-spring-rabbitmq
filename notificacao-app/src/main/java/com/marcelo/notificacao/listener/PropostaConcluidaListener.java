package com.marcelo.notificacao.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcelo.notificacao.constants.MessagemConstant;
import com.marcelo.notificacao.domain.Proposta;
import com.marcelo.notificacao.service.NotificacaoSnsService;

@Component
public class PropostaConcluidaListener {

    @Autowired
    private NotificacaoSnsService notificacaoSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.concluida}")
    public void propostaConcluidaListener(Proposta proposta) {
        String message = "";
        
        if(proposta.getAprovada()) {
            message = String.format(MessagemConstant.PROPOSTA_APROVADA, proposta.getUsuario().getNome());
        } else {
            message = String.format(MessagemConstant.PROPOSTA_NEGADA, proposta.getUsuario().getNome(), proposta.getObservacao());
        }
        
        notificacaoSnsService.notificar(message);
    }

}
