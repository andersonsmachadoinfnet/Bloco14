package br.anderson.infnet.exercicio02;

public class Desconto {
    public static final double DESCONTO_EM_PERCENTUAL = 10.00;
    public static final double VALOR_MINIMO_PARA_DESCONTO = 1000.00;

    public double calcular(double preco) {
        if (podeReceberDesconto(preco)) {
            return concedeDesconto(preco);
        }
        else {
            return preco;
        }
    }

    private boolean podeReceberDesconto(double valor) {
        return valor >= VALOR_MINIMO_PARA_DESCONTO;
    }

    private double concedeDesconto(double valor) {
        return valor * (1 - (DESCONTO_EM_PERCENTUAL/100));
    }
}
