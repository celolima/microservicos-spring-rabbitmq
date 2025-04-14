package com.marcelo.propostaapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.propostaapp.dto.PropostaRequestDTO;
import com.marcelo.propostaapp.dto.PropostaResponseDTO;
import com.marcelo.propostaapp.service.PropostaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponseDTO> criar(@RequestBody PropostaRequestDTO propostaRequestDTO) {
        PropostaResponseDTO response = propostaService.criar(propostaRequestDTO);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(response.getId())
            .toUri()).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDTO>> obterProposta() {
        return ResponseEntity.ok(propostaService.obterProposta());
    }
}
