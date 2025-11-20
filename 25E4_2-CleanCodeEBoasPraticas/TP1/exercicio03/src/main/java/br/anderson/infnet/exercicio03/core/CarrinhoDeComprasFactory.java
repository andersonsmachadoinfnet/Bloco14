package br.anderson.infnet.exercicio03.core;

public class CarrinhoDeComprasFactory {
    public static CarrinhoDeCompras carrinhoDeCompras() {
        return new CarrinhoDeComprasImpl(new CarrinhoDeComprasCalcularImpl());
    }
}
