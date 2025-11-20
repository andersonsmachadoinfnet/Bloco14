package br.anderson.infnet.exercicio04.model;

public class Livro {
    private String titulo;
    private String autor;
    private DisponibilidadeSts disponibilidade;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponibilidade = DisponibilidadeSts.DISPONIVEL;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", disponibilidade=" + disponibilidade +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public DisponibilidadeSts getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(DisponibilidadeSts disponibilidade) {
        if (disponibilidade==DisponibilidadeSts.EMPRESTADO && this.disponibilidade.equals(DisponibilidadeSts.EMPRESTADO)) {
            throw new IllegalArgumentException("O item não está disponível!");
        }
        this.disponibilidade = disponibilidade;
    }
}
