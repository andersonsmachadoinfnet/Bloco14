package br.anderson.infnet.exercicio03.core;

import br.anderson.infnet.exercicio03.model.Item;

import java.util.List;

public interface CarrinhoDeComprasCalcular {
    public void calcularTotal(List<Item> itens);
}
