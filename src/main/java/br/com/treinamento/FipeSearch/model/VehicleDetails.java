package br.com.treinamento.FipeSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleDetails {
    private String brand;
    private String value;
    private int yearModel;


    public VehicleDetails(@JsonProperty("Marca") String brand, @JsonProperty("Valor") String value, @JsonProperty("AnoModelo") int yearModel) {
        this.brand = brand;
        this.value = value;
        this.yearModel = yearModel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    @Override
    public String toString() {
        return "Marca: " + this.brand + " Ano: " + this.yearModel + " Valor: " + this.value;
    }
}
