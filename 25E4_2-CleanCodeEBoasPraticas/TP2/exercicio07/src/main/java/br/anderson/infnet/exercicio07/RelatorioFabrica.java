package br.anderson.infnet.exercicio07;

public class RelatorioFabrica {
    public static Relatorio getRelatorio(String tipo) {
        Relatorio relatorio = null;

        switch (tipo) {
            case "PDF":
                relatorio = new RelatorioPDFImpl();
                break;

            case "CSV":
                relatorio = new RelatorioCSVImpl();
                break;

            case "JSON":
                relatorio = new RelatorioJSONImpl();
                break;

            default:
                throw new IllegalArgumentException("Tipo inválido!");
        }
        return relatorio;
    }
}
