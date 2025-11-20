package br.anderson.infnet.exercicio04.model;

import java.util.List;

public interface Biblioteca {
    public Biblioteca adicionar();
    public Biblioteca emprestar();
    public Biblioteca devolver();

    public Biblioteca livro(String titulo);
    public Biblioteca livro(Livro livro);

    public List<Livro> getLivros();
}
