package br.anderson.infnet.exercicio01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio01Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Calculo.SomaParcelasEDuplicaValor(10, 3));
    }
}
