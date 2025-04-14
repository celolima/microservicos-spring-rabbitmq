package com.pieropan.propostaapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pieropan.propostaapp.config.RabbitMQConfiguration;
import com.pieropan.propostaapp.dto.PropostaRequestDTO;
import com.pieropan.propostaapp.dto.PropostaResponseDTO;
import com.pieropan.propostaapp.entity.Proposta;
import com.pieropan.propostaapp.mapper.PropostaMapper;
import com.pieropan.propostaapp.repository.PropostaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PropostaService {

    private PropostaRepository propostaRepository;
    private NotificacaoService notificacaoService;
    
    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDTO);
        propostaRepository.save(proposta);

        PropostaResponseDTO responseDTO = PropostaMapper.INSTANCE.convertEntityToDto(proposta);
        notificacaoService.notificar(responseDTO, RabbitMQConfiguration.PROPOSTA_PENDENTE_EXCHANGE);
        
        return responseDTO;
    }

    public List<PropostaResponseDTO> obterProposta() {        
        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }

}