package br.com.treinamento.FipeSearch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record CarModelResponse(@JsonAlias("modelos") List<CarModel> models, @JsonAlias("anos") List<CarYear> years) {
}
