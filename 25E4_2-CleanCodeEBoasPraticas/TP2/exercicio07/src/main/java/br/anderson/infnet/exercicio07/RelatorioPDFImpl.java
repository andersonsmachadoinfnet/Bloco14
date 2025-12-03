package br.anderson.infnet.exercicio07;

public class RelatorioPDFImpl implements Relatorio{
    @Override
    public void gerarRelatorio() {
        System.out.println("Gerando relatório em PDF");
        gerarCabecalho();
        gerarCorpo();
        gerarRodape();
    }

    private void gerarRodape() {}
    private void gerarCabecalho() {}
    private void gerarCorpo() {}
}
