package com.example.desafioapi.repository;

import java.sql.Date;
import java.util.List;

import com.example.desafioapi.model.DespesaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<DespesaModel, Long> {

    
    @Query(value = "SELECT * FROM despesas WHERE data_pagamento BETWEEN ?1 AND ?2", nativeQuery = true)
    List<DespesaModel> findByPeriod(Date dataInicio, Date dataFim);

    @Query(value = "SELECT * FROM despesas WHERE tipo_despesa = ?1", nativeQuery = true)
    List<DespesaModel> findByDespesaType(String tipoDespesa);

    
    @Query(value = "SELECT SUM(valor) FROM despesas", nativeQuery = true)
    Float sumDespesa();

    
}
