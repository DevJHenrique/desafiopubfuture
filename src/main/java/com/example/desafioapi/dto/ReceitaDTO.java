package com.example.desafioapi.dto;


import java.sql.Date;

import com.example.desafioapi.enumeration.ReceitaTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReceitaDTO {

  private float valor;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataRecebimento;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataRecebimentoEsperado;
  private String descricao;

  private Long contaId;

  private ReceitaTypeEnum tipoReceita;

  
}
