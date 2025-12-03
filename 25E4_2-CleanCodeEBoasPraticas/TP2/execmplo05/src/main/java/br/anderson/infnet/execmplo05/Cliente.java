package br.anderson.infnet.execmplo05;

public class Cliente {
    private String nome;
    private int idade;
    private double renda;
    private int compas;
    private String localizacao;

    public Cliente(String nome, int idade, double renda, int compas, String localizacao) {
        this.nome = nome;
        this.idade = idade;
        this.renda = renda;
        this.compas = compas;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public int getCompas() {
        return compas;
    }

    public void setCompas(int compas) {
        this.compas = compas;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
