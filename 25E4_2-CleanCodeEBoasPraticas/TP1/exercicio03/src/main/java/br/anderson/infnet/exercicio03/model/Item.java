package br.anderson.infnet.exercicio03.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Item {
    private String nome;
    private Double preco;
    private Double quantidade;

    public Item(String nome, Double preco, Double quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
