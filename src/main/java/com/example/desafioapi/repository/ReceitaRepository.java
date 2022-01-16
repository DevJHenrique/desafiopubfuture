package com.example.desafioapi.repository;

import java.sql.Date;
import java.util.List;

import com.example.desafioapi.model.ReceitaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<ReceitaModel, Long> {


    @Query(value = "SELECT * FROM receitas WHERE data_recebimento BETWEEN ?1 AND ?2", nativeQuery = true)
    List<ReceitaModel> findByPeriod(Date dataInicio, Date dataFim);

    @Query(value = "SELECT * FROM receitas WHERE tipo_receita = ?1", nativeQuery = true)
    List<ReceitaModel> findByReceitaType(String tipoReceita);

    
    @Query(value = "SELECT SUM(valor) FROM receitas", nativeQuery = true)
    Float sumReceita();


}
    
