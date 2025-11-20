package br.anderson.infnet.exemplo07;

import br.anderson.infnet.exemplo07.core.BancoImpl;
import br.anderson.infnet.exemplo07.model.Banco;
import br.anderson.infnet.exemplo07.model.Conta;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exemplo07Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exemplo07Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Banco banco = new BancoImpl();
        banco.adicionar(new Conta("Fulano", 100.00));
        banco.adicionar(new Conta("Ciclano", 150.00));

        banco.contaPeloTitular("Fulano").depositar(50.00);
        banco.contaPeloTitular("Ciclano").sacar(150.00);
        banco.listaSaldos();
    }
}
