package br.anderson.infnet.exercicio12.model;

public class PagamentoCartao extends Pagamento{
    public PagamentoCartao(Double valor) {
        super(TipoPagamento.CARTAO, valor);
    }

    @Override
    public void processar() {
        System.out.println("Pagamento de R$"+getValor()+" realizado em cartão.");
    }
}
