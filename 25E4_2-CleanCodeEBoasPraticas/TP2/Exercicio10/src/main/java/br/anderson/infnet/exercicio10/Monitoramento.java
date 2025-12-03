package br.anderson.infnet.exercicio10;

public class Monitoramento {
    private int contadorAcessos = 0;

    // QUERY — apenas retorna, não altera
    public int getContadorAcessos() {
        return contadorAcessos;
    }

    // COMMAND — altera estado, não retorna informação relevante
    public void incrementarAcessos() {
        contadorAcessos++;
    }
}
