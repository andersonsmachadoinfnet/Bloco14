package br.anderson.infnet.exercicio02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio02Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Desconto desconto = new Desconto();
        System.out.println(desconto.calcular(1000));
    }
}
