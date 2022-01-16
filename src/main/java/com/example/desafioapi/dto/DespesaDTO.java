package com.example.desafioapi.dto;

import java.sql.Date;

import com.example.desafioapi.enumeration.DespesaTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DespesaDTO {
    private float valor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagemento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagementoEsperado;
    
    private Long contaId;

    private DespesaTypeEnum tipoDespesa;
}
