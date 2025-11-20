package br.anderson.infnet.exercicio10.core;

public class Processar {
    public void processar(String dado) {
        if (dado == null) {
            throw new NullPointerException("Dado nulo");
        }
        else {
            System.out.println("Processando: " + dado.toUpperCase());
        }
    }
}
