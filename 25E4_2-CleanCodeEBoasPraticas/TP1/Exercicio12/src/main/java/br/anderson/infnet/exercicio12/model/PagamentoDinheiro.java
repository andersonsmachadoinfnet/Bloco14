package br.anderson.infnet.exercicio12.model;

public class PagamentoDinheiro extends Pagamento {
    public PagamentoDinheiro(Double valor) {
        super(TipoPagamento.DINHEIRO, valor);
    }

    @Override
    public void processar() {
        System.out.println("Pagamento de R$"+getValor()+" realizado em dinheiro.");
    }
}
