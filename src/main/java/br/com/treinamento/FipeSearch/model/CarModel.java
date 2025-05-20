package br.com.treinamento.FipeSearch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record CarModel(@JsonAlias("codigo") String code, @JsonAlias("nome") String name) {

    @Override
    public String toString() {
        return "Código: " + code + " / (name: " + name + ")";
    }
}
