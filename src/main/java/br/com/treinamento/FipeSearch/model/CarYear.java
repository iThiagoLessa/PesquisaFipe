package br.com.treinamento.FipeSearch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record CarYear(@JsonAlias("codigo") String code, @JsonAlias("nome") String name) {

    @Override
    public String toString() {
        return "Codigo:" + code + " / (nome: " + name + ")";

    }
}
