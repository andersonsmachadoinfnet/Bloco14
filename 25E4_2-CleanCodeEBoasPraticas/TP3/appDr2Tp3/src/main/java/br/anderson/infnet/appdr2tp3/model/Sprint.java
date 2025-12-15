package br.anderson.infnet.appdr2tp3.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record Sprint (Long id, String nome, LocalDateTime dtInicio, LocalDateTime dtFim, List<Task> tarefas) {

    public Sprint {
        tarefas = new ArrayList<Task>();
    }

    public void adicionarTarefa(Task task) {
        tarefas.add(task);
    }

    public void removerTarefa(Task task) {
        int index = tarefas.indexOf(task);
        tarefas.remove(index);
    }

    public void listarTarefas() {
        System.out.println("Listagem de tarefas do Sprint: "+nome);
        for (Task task : tarefas) {
            System.out.println(task);
        }
    }
}
