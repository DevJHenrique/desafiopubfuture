package com.example.desafioapi.enumeration;

public enum ReceitaTypeEnum {
    
    SALARIO("salário"),
    PRESENTE("presente"),
    PREMIO("prêmio"),
    OUTROS("outros");
    
    private String value;
    
    ReceitaTypeEnum(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
    
}
    
