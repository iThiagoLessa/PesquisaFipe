package br.com.treinamento.FipeSearch.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ConvertData implements GenericInterface {
    private final ObjectMapper javaObjectMapper = new ObjectMapper();


    @Override
    public <T> T getData(String json, Class<T> object) {
        try {
            return javaObjectMapper.readValue(json, object);
        }  catch (Exception e){
            System.out.println("erro ao converter os dados para o objeto java");
            throw new RuntimeException(e);
        }
    }

    // Novo método com TypeReference<T>
    // para converter caso seja um array e nao um objeto
    public <T> T getData(String json, TypeReference<T> typeReference) {
        try {
            return javaObjectMapper.readValue(json, typeReference);
        } catch (Exception e) {
            System.out.println("erro ao converter os dados para o objeto java (TypeReference)");
            throw new RuntimeException(e);
        }
    }
}
