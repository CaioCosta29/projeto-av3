package com.projeto_av3.projeto_av3.model.enums;

public enum Genero {
    Masculino("M"),
    Feminino("F");

    private final String valor;

    Genero(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
