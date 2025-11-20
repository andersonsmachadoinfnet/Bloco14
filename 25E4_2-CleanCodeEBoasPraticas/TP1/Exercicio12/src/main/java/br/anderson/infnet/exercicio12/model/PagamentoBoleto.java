package br.anderson.infnet.exercicio12.model;

public class PagamentoBoleto extends Pagamento {
    public PagamentoBoleto(Double valor) {
        super(TipoPagamento.DINHEIRO, valor);
    }

    @Override
    public void processar() {
        System.out.println("Pagamento de R$"+getValor()+" realizado em boleto.");
    }
}
