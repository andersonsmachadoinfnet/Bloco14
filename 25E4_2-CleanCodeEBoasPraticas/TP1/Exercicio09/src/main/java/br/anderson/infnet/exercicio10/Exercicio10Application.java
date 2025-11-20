package br.anderson.infnet.exercicio10;

import br.anderson.infnet.exercicio10.core.Processador;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio10Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio10Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Processador processador = new Processador();
        processador.executar("Fazendo algo...");
    }
}
