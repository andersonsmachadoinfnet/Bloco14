package br.anderson.infnet.exercicio07;

public class RelatorioCSVImpl implements Relatorio{
    @Override
    public void gerarRelatorio() {
        System.out.println("Gerando relatório em CSV");
        gerarCabecalho();
        gerarCorpo();
        gerarRodape();
    }

    private void gerarRodape() {}
    private void gerarCabecalho() {}
    private void gerarCorpo() {}
}
