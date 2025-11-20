package br.anderson.infnet.exercicio04.core;

import br.anderson.infnet.exercicio04.model.Biblioteca;
import br.anderson.infnet.exercicio04.model.Livro;

public class BibliotecaReport {
    Biblioteca biblioteca;

    public BibliotecaReport(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void listar() {
        System.out.println("Relação de Livros:");
        for(Livro itm: biblioteca.getLivros()) {
            System.out.println(itm);
        }
    }
}
