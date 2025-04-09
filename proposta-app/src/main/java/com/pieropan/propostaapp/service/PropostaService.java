package com.pieropan.propostaapp.service;

import org.springframework.stereotype.Service;

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
    
    public PropostaResponseDTO criar(PropostaRequestDTO requestDTO) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDTO);
        propostaRepository.save(proposta);

        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

}