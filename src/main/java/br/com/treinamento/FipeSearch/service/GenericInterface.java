package br.com.treinamento.FipeSearch.service;

public interface GenericInterface {
    <T> T getData(String json, Class<T> object);
}
