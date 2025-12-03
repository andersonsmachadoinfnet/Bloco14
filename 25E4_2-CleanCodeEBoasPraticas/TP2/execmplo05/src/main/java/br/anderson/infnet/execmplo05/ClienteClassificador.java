package br.anderson.infnet.execmplo05;

import java.util.List;

public class ClienteClassificador {
    private List<ClassificadorStrategy> classificadores;

    public ClienteClassificador(List<ClassificadorStrategy> classificadores) {
        this.classificadores = classificadores;
    }

    public String classificarCliente(Cliente cliente) {
        String classificacao = "";
        for (ClassificadorStrategy classificadorStrategy : classificadores) {
            classificacao = classificadorStrategy.classificar(cliente);
            if (!classificacao.equals("")) {
                return classificacao;
            }
        }
        return classificacao;
    }
}
