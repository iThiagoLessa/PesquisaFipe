package br.com.treinamento.FipeSearch;

import br.com.treinamento.FipeSearch.aplication.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeSearchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FipeSearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal main = new Principal();

        main.Main();
    }
}
