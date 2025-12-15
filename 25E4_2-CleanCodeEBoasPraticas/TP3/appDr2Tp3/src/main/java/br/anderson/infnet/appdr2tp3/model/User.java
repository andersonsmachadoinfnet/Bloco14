package br.anderson.infnet.appdr2tp3.model;

public class User {
    private final String nome;
    private final String email;
    private final String cargo;

    public User(String nome, String email, String cargo) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    public User atualizaEmail(String email) {
        return new User(this.nome, email, this.cargo);
    }

    public User definirCargo(String cargo) {
        return new User(this.nome, this.email, cargo);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
