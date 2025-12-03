package br.anderson.infnet.exemplo04;

public class Ajuste {
    private final Double VALOR_DESCONTO = 10.00;

    public Double aplicarDesconto(final Produto produto) {
        return produto.getPreco() - VALOR_DESCONTO;
    }
}
