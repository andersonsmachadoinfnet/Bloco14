package br.anderson.infnet.appdr2tp3.model;

public class Task implements Prototype<Task>{
    private final String titulo;
    private final String descricao;
    private final TarefaStatus status;
    private final String responsavel;

    public Task(String titulo, String descricao, TarefaStatus status, String responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
    }

    public Task atribuirResponsavel(String responsavel) {
        return new Task(this.getTitulo(), this.getDescricao(), this.getStatus(), responsavel);
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

    public String getResponsavel() {
        return responsavel;
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
        return new Task(obj.getTitulo(), obj.getDescricao(), obj.getStatus(), obj.getResponsavel());
    }
}
