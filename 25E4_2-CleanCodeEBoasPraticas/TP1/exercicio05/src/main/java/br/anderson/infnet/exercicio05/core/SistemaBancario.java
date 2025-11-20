package br.anderson.infnet.exercicio05.core;

import br.anderson.infnet.exercicio05.model.Conta;
import br.anderson.infnet.exercicio05.model.ContaOperacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SistemaBancario {
    private List<Conta> contas;

    public SistemaBancario() {
        contas = new ArrayList<Conta>();
    }

    public void criarConta(Conta conta) {
        contas.add(conta);
    }

    public void transferir(String titularOrigem, String titularDestino, double valor) {
        ContaOperacao origem=null;
        ContaOperacao destino=null;

        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getTitular().equals(titularOrigem)) {
              origem = contas.get(i);
            }
            if (contas.get(i).getTitular().equals(titularDestino)) {
                destino = contas.get(i);
            }
        }

        if (origem==null || destino == null) {
            throw new IllegalArgumentException("Origem ou Destino não encontrados!");
        }

        origem.sacar(valor);
        destino.depositar(valor);
    }

    public void listaSaldos() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }
}
