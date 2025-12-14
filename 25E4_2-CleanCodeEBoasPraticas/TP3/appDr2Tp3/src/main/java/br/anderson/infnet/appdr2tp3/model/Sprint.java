package br.anderson.infnet.appdr2tp3.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sprint {
    private final String nome;
    private final LocalDateTime dtInicio;
    private final LocalDateTime dtFim;
    private final List<Task> tarefas;

    public Sprint(String nome, LocalDateTime dtInicio, LocalDateTime dtFim) {
        this.nome = nome;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.tarefas = new ArrayList<Task>();
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDtInicio() {
        return dtInicio;
    }

    public LocalDateTime getDtFim() {
        return dtFim;
    }

    public List<Task> getTarefas() {
        return tarefas;
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "nome='" + nome + '\'' +
                ", dtInicio=" + dtInicio +
                ", dtFim=" + dtFim +
                ", tarefas=" + tarefas +
                '}';
    }
}
