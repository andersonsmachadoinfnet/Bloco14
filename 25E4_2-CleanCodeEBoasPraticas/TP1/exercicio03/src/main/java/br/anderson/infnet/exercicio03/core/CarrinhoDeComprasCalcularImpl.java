package br.anderson.infnet.exercicio03.core;

import br.anderson.infnet.exercicio03.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeComprasCalcularImpl implements CarrinhoDeComprasCalcular {
    @Override
    public void calcularTotal(List<Item> itens) {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        System.out.println("Total da compra: R$ " + total);
    }
}
