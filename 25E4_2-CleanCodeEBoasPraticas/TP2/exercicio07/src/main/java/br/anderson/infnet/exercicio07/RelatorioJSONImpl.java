package br.anderson.infnet.exercicio07;

public class RelatorioJSONImpl implements Relatorio{
    @Override
    public void gerarRelatorio() {
        System.out.println("Gerando relatório em JSON");
        gerarCabecalho();
        gerarCorpo();
        gerarRodape();
    }

    private void gerarRodape() {}
    private void gerarCabecalho() {}
    private void gerarCorpo() {}
}
