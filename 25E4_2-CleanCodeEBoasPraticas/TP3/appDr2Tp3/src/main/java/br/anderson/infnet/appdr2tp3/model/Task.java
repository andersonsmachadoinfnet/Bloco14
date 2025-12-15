package br.anderson.infnet.appdr2tp3.model;

import java.util.Objects;

public class Task implements Prototype<Task>{
    private final Integer id = null;    // Um identificador único do banco
    private final String titulo;
    private final String descricao;
    private final TarefaStatus status;  // Um valor que faça sentido
    private final User responsavel;
    private final Integer estimativa;   // Estimativa do Scrum Poker  (uma medida relevante)

    public Task(String titulo, String descricao, TarefaStatus status, User responsavel, Integer estimativa) {
        Objects.requireNonNull(estimativa, "Estimativa da tarefa não foi definida!");
        if (estimativa < 0 || estimativa > 100) {
            throw new IllegalArgumentException("Estimativa deve ser entre 0 e 100");
        }

        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
        this.estimativa = estimativa;
    }

    public Task atribuirResponsavel(User responsavel) {
        return new Task(this.getTitulo(), this.getDescricao(), this.getStatus(), responsavel, this.estimativa);
    }

    public Task alterarStatus(TarefaStatus status) {
        return new Task(this.getTitulo(), this.getDescricao(), status, this.responsavel, this.estimativa);
    }

    public void exibirDetalhes() {
        System.out.println(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public TarefaStatus getStatus() {
        return status;
    }

    public User getResponsavel() {
        return responsavel;
    }

    public Integer getEstimativa() {
        return estimativa;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status + '\'' +
                ", responsavel=" + responsavel +
                '}';
    }

    @Override
    public Task clonar(Task obj) {
        return new Task(obj.getTitulo(), obj.getDescricao(), obj.getStatus(), obj.getResponsavel(), getEstimativa());
    }
}
