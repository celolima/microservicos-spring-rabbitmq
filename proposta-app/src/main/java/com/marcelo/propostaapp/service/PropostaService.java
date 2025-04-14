package com.marcelo.propostaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.marcelo.propostaapp.dto.PropostaRequestDTO;
import com.marcelo.propostaapp.dto.PropostaResponseDTO;
import com.marcelo.propostaapp.entity.Proposta;
import com.marcelo.propostaapp.mapper.PropostaMapper;
import com.marcelo.propostaapp.repository.PropostaRepository;

@Service
public class PropostaService {

    @Value("${rabbitmq.propostapendente.exchange}")
    private String exchange;

    @Autowired
    private PropostaRepository propostaRepository;
    
    @Autowired
    private NotificacaoRabbitMQService notificacaoService;
    
    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDTO);
        propostaRepository.save(proposta);

        notificarRabbitMQ(proposta);

        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta) {
        try {
            notificacaoService.notificar(proposta, exchange);
        } catch(RuntimeException exception) {
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }
    }

    public List<PropostaResponseDTO> obterProposta() {        
        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }

}