package br.anderson.infnet.exercicio12;

import br.anderson.infnet.exercicio12.model.Pagamento;
import br.anderson.infnet.exercicio12.model.PagamentoFabrica;
import br.anderson.infnet.exercicio12.service.PagamentoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio12Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Pagamento boleto = PagamentoFabrica.getPagamento("boleto", 100.00);
        Pagamento dinheiro = PagamentoFabrica.getPagamento("dinheiro", 50.00);
        PagamentoService pagamentoService = new PagamentoService();
        pagamentoService.processarPagamento(boleto);
        pagamentoService.processarPagamento(dinheiro);
    }
}
