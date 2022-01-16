package com.example.desafioapi.enumeration;

public enum ContaTypeEnum {
    CARTEIRA("carteira"),
    CONTA_CORRENTE("conta corrente"),
    POUPANCA("poupança");

    private String value;

    ContaTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
