package br.anderson.infnet.exercicio06.core;

import br.anderson.infnet.exercicio06.model.Banco;
import br.anderson.infnet.exercicio06.model.Conta;

public class RelatorioFinanceiroParteCorpoImpl implements RelatorioFinanceiroParte {
    private Banco banco;

    public RelatorioFinanceiroParteCorpoImpl(Banco banco) {
        this.banco = banco;
    }

    @Override
    public void apresenta() {
        for (Conta conta : banco.getContas()) {
            System.out.println(conta);
        }
    }
}
