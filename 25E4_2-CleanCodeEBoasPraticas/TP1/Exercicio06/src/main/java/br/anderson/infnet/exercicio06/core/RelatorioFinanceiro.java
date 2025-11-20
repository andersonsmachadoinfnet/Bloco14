package br.anderson.infnet.exercicio06.core;

import br.anderson.infnet.exercicio06.model.Banco;

import java.util.ArrayList;
import java.util.List;

public class RelatorioFinanceiro {
    private List<RelatorioFinanceiroParte> relatorios;

    public RelatorioFinanceiro(Banco banco) {
        relatorios = new ArrayList<>();
        relatorios.add(new RelatorioFinanceiroParteCabecalhoImpl());
        relatorios.add(new RelatorioFinanceiroParteCorpoImpl(banco));
        relatorios.add(new RelatorioFinanceiroParteRodapeImpl());
    }

    public void gerarRelatorio() {
        for (RelatorioFinanceiroParte parte : relatorios) {
            parte.apresenta();
        }
    }
}
