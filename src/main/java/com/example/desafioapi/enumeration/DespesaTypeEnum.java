package com.example.desafioapi.enumeration;

public enum DespesaTypeEnum {

    ALIMENTACAO("alimentação"),
    EDUCACAO("educação"),
    LAZER("lazer"),
    MORADIA("moradia"),
    ROUPA("roupa"),
    SAUDE("saúde"),
    TRANSPORTE("transporte"),
    OUTROS("outros");

    private String value;

    DespesaTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    
}
