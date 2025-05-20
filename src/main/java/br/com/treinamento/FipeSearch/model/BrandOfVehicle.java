package br.com.treinamento.FipeSearch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record BrandOfVehicle(@JsonAlias("codigo") String code, @JsonAlias("nome") String name) {

    @Override
    public String toString() {
        return
                "{ code: " + code + ", nome: " + name + "}";
    }
}
