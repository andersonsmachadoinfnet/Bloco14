package br.anderson.infnet.exercicio03;

import br.anderson.infnet.exercicio03.core.CarrinhoDeCompras;
import br.anderson.infnet.exercicio03.core.CarrinhoDeComprasFactory;
import br.anderson.infnet.exercicio03.model.Item;
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
        CarrinhoDeCompras carrinho = CarrinhoDeComprasFactory.carrinhoDeCompras();
        carrinho.adicionar(new Item("Coca-Cola 2L", 12.00, 1.00));
        carrinho.adicionar(new Item("Hamburguer", 20.00, 1.00));
        carrinho.adicionar(new Item("Pastel", 8.00, 1.00));
        carrinho.calcular();
    }
}
