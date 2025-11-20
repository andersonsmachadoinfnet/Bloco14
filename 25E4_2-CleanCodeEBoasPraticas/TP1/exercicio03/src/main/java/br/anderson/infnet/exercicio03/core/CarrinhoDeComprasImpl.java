package br.anderson.infnet.exercicio03.core;

import br.anderson.infnet.exercicio03.model.Item;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeComprasImpl implements CarrinhoDeCompras {
    private List<Item> itens;
    private CarrinhoDeComprasCalcular carrinhoCalcular;

    public CarrinhoDeComprasImpl(CarrinhoDeComprasCalcular carrinhoCalcular) {
        this.itens = new ArrayList<Item>();
        this.carrinhoCalcular = carrinhoCalcular;
    }

    @Override
    public void adicionar(Item item) {
        itens.add(item);
    }

    @Override
    public void calcular() {
        carrinhoCalcular.calcularTotal(itens);
    }
}
