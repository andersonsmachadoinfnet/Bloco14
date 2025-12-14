package br.anderson.infnet.appdr2tp3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private final String nome;
    private final String descricao;
    private final List<Sprint> sprints;

    public Project(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.sprints = new ArrayList<Sprint>();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    @Override
    public String toString() {
        return "Project{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", sprints=" + sprints +
                '}';
    }
}
