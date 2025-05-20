package br.com.treinamento.FipeSearch.aplication;

import br.com.treinamento.FipeSearch.model.*;
import br.com.treinamento.FipeSearch.service.ConvertData;
import br.com.treinamento.FipeSearch.service.GetService;
import com.fasterxml.jackson.core.type.TypeReference;


import java.util.*;

public class Principal {
    private final GetService getData = new GetService();
    Scanner read = new Scanner(System.in);

    private final ArrayList<String> typesOfVehicle = new ArrayList<>(Arrays.asList("Carros", "Motos", "Caminhões"));
    private final List<VehicleDetails> detailsList = new ArrayList<>();

    ConvertData convertData = new ConvertData();


    public void Main() {

        // esse forma faz a mesmo coisa que o for acima, porem aqui esta utilizando lambda
        typesOfVehicle.forEach(System.out::println);

        System.out.println("Escolha um tipo de veiculo: ");

        var vehicle = read.nextLine();

        System.out.println("veiculo escolhido: " + vehicle);

        boolean isValidVehicle = typesOfVehicle.stream().anyMatch(item -> item.equalsIgnoreCase(vehicle));

        if (isValidVehicle) {
            String responseBrandOfVehicles = getData.getApi("https://parallelum.com.br/fipe/api/v1/" + vehicle + "/marcas");
            List<BrandOfVehicle> listOfBrandVehicle = convertData.getData(responseBrandOfVehicles, new TypeReference<>() {
            });


            listOfBrandVehicle.forEach(System.out::println);

            System.out.println("Digite o código da marca desejada: ");
            String code = read.nextLine();

            System.out.println("Código da marca selecionado: " + code);

            String responseOfModelCar = getData.getApi("https://parallelum.com.br/fipe/api/v1/" + vehicle + "/marcas/" + code + "/modelos");


            CarModelResponse carModelResponse = convertData.getData(responseOfModelCar, CarModelResponse.class);

            carModelResponse.models().forEach(System.out::println);

            System.out.println("Digite o nome do modelo do carro que você está querendo: ");
            String search = read.nextLine();

            Optional<CarModel> searched = carModelResponse.models().stream().filter(item -> item.name().toLowerCase().contains(search.toLowerCase())).findFirst();

            if (searched.isPresent()) {
                System.out.println("Modelo encontrado: " + searched.get());
                System.out.println("Confirmar modelo? ");
                String confirm = read.nextLine();

                switch (confirm.toLowerCase()) {
                    case "sim":
                        String responseOfCarYear = getData.getApi("https://parallelum.com.br/fipe/api/v1/" + vehicle + "/marcas/" + code + "/modelos/" + searched.get().code() + "/anos");


                        System.out.println("response of car ai: " + responseOfCarYear);

                        List<CarYear> listCarYers = convertData.getData(responseOfCarYear, new TypeReference<>() {
                        });



                        listCarYers.forEach(item -> {
                            String responseOfCarDetails = getData.getApi("https://parallelum.com.br/fipe/api/v1/" + vehicle + "/marcas/" + code + "/modelos/" + searched.get().code() + "/anos/" + item.code());

                            System.out.println("reponse responseOfCarDetails" + responseOfCarDetails);
                            VehicleDetails vehicleDetails = convertData.getData(responseOfCarDetails, VehicleDetails.class);

                            detailsList.add(vehicleDetails);
                        });


                        break;
                    case "nao":
                        System.out.println("nao confirmado");
                        break;
                    default:
                        System.out.println("Opção inválida. Digite apenas sim ou nao");
                }


                System.out.println("Veiculos filtrados com avaliação por ano: ");

                // aqui só estou printando meu objeto de detalhes do veiculo
                detailsList.forEach(System.out::println);


            } else {
                System.out.println("Modelo nao encontrado");
            }

        } else {
            System.out.println("Veiculo Inválido");
        }


    }
}
