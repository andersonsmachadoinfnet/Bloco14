package br.anderson.infnet.exercicio07;

public class RelatorioService {
    public void gerarRelatorio(String tipo) {
        Relatorio relatorio = RelatorioFabrica.getRelatorio(tipo);
        relatorio.gerarRelatorio();
    }
}
