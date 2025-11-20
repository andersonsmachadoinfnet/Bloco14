package br.anderson.infnet.exercicio04.core;

import br.anderson.infnet.exercicio04.model.Biblioteca;
import br.anderson.infnet.exercicio04.model.DisponibilidadeSts;
import br.anderson.infnet.exercicio04.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class BibliotecaImpl implements Biblioteca {
    private List<Livro> livros;
    private Livro livro;

    public BibliotecaImpl() {
        livros = new ArrayList<Livro>();
    }

    @Override
    public Biblioteca adicionar() {
        Objects.requireNonNull(livro);
        livros.add(livro);
        return this;
    }

    @Override
    public Biblioteca emprestar() {
        Objects.requireNonNull(livro);
        livro.setDisponibilidade(DisponibilidadeSts.EMPRESTADO);
        return this;
    }

    @Override
    public Biblioteca devolver() {
        Objects.requireNonNull(livro);
        livro.setDisponibilidade(DisponibilidadeSts.DISPONIVEL);
        return this;
    }

    @Override
    public Biblioteca livro(String titulo) {
        livro = null;
        for (Livro item : livros) {
            if (item.getTitulo().equals(titulo)) {
                livro = item;
            }
        }
        if (livro == null) {
            throw new NoSuchElementException();
        }

        return this;
    }

    @Override
    public Biblioteca livro(Livro livro) {
        this.livro = livro;
        return this;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
