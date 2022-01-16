package com.example.desafioapi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.desafioapi.enumeration.ContaTypeEnum;

import lombok.Data;

@Data
@Entity
@Table(name = "contas")
public class ContaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float saldo;
    private String instituicaoFinanceira;

    @Enumerated(EnumType.STRING)
    private ContaTypeEnum tipoConta;

    
}
