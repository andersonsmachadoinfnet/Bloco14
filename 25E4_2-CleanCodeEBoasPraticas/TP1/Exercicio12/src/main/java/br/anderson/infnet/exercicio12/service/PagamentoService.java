package br.anderson.infnet.exercicio12.service;

import br.anderson.infnet.exercicio12.model.PagamentoOperacao;

public class PagamentoService {
    public void processarPagamento(PagamentoOperacao pagamento) {
        pagamento.processar();
    }
}
