package com.example.desafioapi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.desafioapi.enumeration.ReceitaTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "receitas")
public class ReceitaModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private float valor;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataRecebimento;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataRecebimentoEsperado;
  private String descricao;

  @JoinColumn(name = "conta_id", referencedColumnName = "id")
  @ManyToOne
  private ContaModel conta;
  
  @Enumerated(EnumType.STRING)
  private ReceitaTypeEnum tipoReceita;

  
}
