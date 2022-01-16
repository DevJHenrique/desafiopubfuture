package com.example.desafioapi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.desafioapi.enumeration.DespesaTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "depesas")
public class DespesaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float valor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagemento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagementoEsperado;
    
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ContaModel conta;

    @Enumerated(EnumType.STRING)
    private DespesaTypeEnum tipoDespesa;
}
