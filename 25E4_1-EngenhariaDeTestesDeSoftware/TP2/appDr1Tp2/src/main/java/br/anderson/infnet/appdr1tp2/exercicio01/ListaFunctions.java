package br.anderson.infnet.appdr1tp2.exercicio01;

import java.util.List;

public class ListaFunctions {

    /**
     * Função simples que ordena uma lista;
     *
     * @param lista É a lista a ser ordenada
     */
    public static List<Integer> ordenar(List<Integer> lista) {
        return lista.stream().sorted().toList();
    }
}
