package br.anderson.infnet.exercicio12.model;

public class Pagamento implements PagamentoOperacao{
    private TipoPagamento tipoPagamento;
    private Double valor;

    public Pagamento(TipoPagamento tipoPagamento, Double valor) {
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "tipoPagamento=" + tipoPagamento +
                ", valor=" + valor +
                '}';
    }

    @Override
    public void processar() {

    }
}
