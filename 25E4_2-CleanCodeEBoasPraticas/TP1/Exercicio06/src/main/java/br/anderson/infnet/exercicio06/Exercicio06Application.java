package br.anderson.infnet.exercicio06;

import br.anderson.infnet.exercicio06.core.RelatorioFinanceiro;
import br.anderson.infnet.exercicio06.model.Banco;
import br.anderson.infnet.exercicio06.model.Conta;
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
        Banco banco = new Banco();
        banco.adicionarConta(new Conta(100.00, "Fulano"));
        banco.adicionarConta(new Conta(150.00, "Ciclano"));

        RelatorioFinanceiro relatorioFinanceiro = new RelatorioFinanceiro(banco);
        relatorioFinanceiro.gerarRelatorio();
    }
}
