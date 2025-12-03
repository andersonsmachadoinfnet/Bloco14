package br.anderson.infnet.exercicio06;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio06Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio06Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        NationalityColors corBandeira = new NationalityColorsImpl();
        System.out.println(corBandeira.getFlagColors(Nationality.BELGIAN));
    }
}
