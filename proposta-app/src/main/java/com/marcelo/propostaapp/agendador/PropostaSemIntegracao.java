package com.marcelo.propostaapp.agendador;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.marcelo.propostaapp.entity.Proposta;
import com.marcelo.propostaapp.repository.PropostaRepository;
import com.marcelo.propostaapp.service.NotificacaoRabbitMQService;

@Component
public class PropostaSemIntegracao {

    private final Logger logger = LoggerFactory.getLogger(PropostaSemIntegracao.class);

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private NotificacaoRabbitMQService notificacaoService;

    @Value("${rabbitmq.propostapendente.exchange}")
    private String exchange;

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void buscarPropostaSemIntegracao() {
        logger.info("Nova tentativa de envio das propostas não integradas.");
        this.propostaRepository.findAllByIntegradaFalse().forEach(proposta -> {
            try {
                notificacaoService.notificar(proposta, exchange);
                atualizarProposta(proposta);
            } catch(RuntimeException exception) {
                logger.error("Erro no envio da proposta", exception);
            }
        });
    }

    private void atualizarProposta(Proposta proposta) {
        proposta.setIntegrada(true);
        propostaRepository.save(proposta);
    }

}
