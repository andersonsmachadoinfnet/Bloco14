package br.anderson.infnet.exercicio03;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio03Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Pedido pedido = new Pedido(null);
        System.out.println("Cliente: "+pedido.getNomeCliente());
    }
}
