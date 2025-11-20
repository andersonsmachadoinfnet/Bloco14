package br.anderson.infnet.exercicio12.model;

public class PagamentoFabrica {
    public static Pagamento getPagamento(String tipoPagamento, double valorPagamento) {
        Pagamento pagamento = null;

        switch (tipoPagamento.toUpperCase()) {
            case "DINHEIRO":
                pagamento = new PagamentoDinheiro(valorPagamento);
                break;
            case "CARTAO":
                pagamento = new PagamentoCartao(valorPagamento);
                break;
            case "BOLETO":
                pagamento = new PagamentoBoleto(valorPagamento);
                break;
            default:
                throw new IllegalArgumentException("Tipo de pagamento Invalido:  "+tipoPagamento.toUpperCase());
        }
        return pagamento;
    }
}
