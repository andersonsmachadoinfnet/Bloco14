package br.anderson.infnet.exemplo04;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exemplo04Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exemplo04Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Produto produto = new Produto("COCA COLA 24 UN", 35.00);
        Ajuste ajuste = new Ajuste();
        System.out.println(ajuste.aplicarDesconto(produto));
    }
}
