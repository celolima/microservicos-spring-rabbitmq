package com.marcelo.propostaapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.propostaapp.entity.Proposta;

import jakarta.transaction.Transactional;

@Repository
public interface PropostaRepository extends CrudRepository<Proposta, Long>{

    List<Proposta> findAllByIntegradaFalse();

    @Query(value = "SELECT COUNT(id) FROM Proposta where integrada = false")
    Long countPropostaIntegradaFalse();

    @Transactional
    @Modifying
    @Query(value = "UPDATE Proposta SET aprovada = :aprovada, observacao = :observacao WHERE id = :id", nativeQuery = true)
    void atualizarProposta(Long id, boolean aprovada, String observacao);

}
