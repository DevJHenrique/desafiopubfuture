package com.example.desafioapi.repository;

import com.example.desafioapi.model.ContaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaRepository extends JpaRepository<ContaModel, Long> {

    @Query(value = "SELECT SUM(saldo) FROM contas", nativeQuery = true)
    Float sumSaldoContas();

}
    