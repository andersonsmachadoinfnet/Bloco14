package br.anderson.infnet.exemplo11.service;

public class Servico {
    public void processar(String dado) {
        if (dado == null) {
            throw new IllegalArgumentException("Valor nulo!");
        }
        System.out.println("Processando: "+dado);
    }
}
