package br.anderson.infnet.execmplo05;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Execmplo05Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Execmplo05Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente clienteSenior = new Cliente("Fulano", 61, 6000.00, 20, "");
        Cliente clienteJovem = new Cliente("Ciclano", 25, 9000.00, 40, "");
        ClienteClassificador classificador = ClienteClassificadorFabrica.getClassificador();

        System.out.println(classificador.classificarCliente(clienteSenior));
        System.out.println(classificador.classificarCliente(clienteJovem));
    }
}
