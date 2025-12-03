package br.anderson.infnet.exercicio09;

import java.util.LinkedList;
import java.util.Queue;

public class FilaMensagens {
    private final Queue<String> mensagens = new LinkedList<>();

    // QUERY: apenas retorna, não altera estado
    public String peekProximaMensagem() {
        return mensagens.peek();
    }

    // COMMAND
    public boolean removerProximaMensagem() {
        if (mensagens.isEmpty()) {
            return false;
        }
        mensagens.poll();
        return true;
    }

    // COMMAND
    public void adicionarMensagem(String mensagem) {
        mensagens.add(mensagem);
    }

    // QUERY
    public int quantidade() {
        return mensagens.size();
    }
}
