package br.anderson.infnet.exercicio05;

import br.anderson.infnet.exercicio05.core.SistemaBancario;
import br.anderson.infnet.exercicio05.model.Conta;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio05Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio05Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SistemaBancario banco = new SistemaBancario();
        banco.criarConta(new Conta(100.00, "Fulano"));
        banco.criarConta(new Conta(100.00, "Ciclano"));

        banco.transferir("Fulano", "Ciclano", 50.00);
        banco.listaSaldos();
    }
}
