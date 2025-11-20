package br.anderson.infnet.exemplo07.core;

import br.anderson.infnet.exemplo07.model.Banco;
import br.anderson.infnet.exemplo07.model.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BancoImpl implements Banco {
    private List<Conta> contas;
    private Conta conta;

    public BancoImpl() {
        contas = new ArrayList<Conta>();
    }

    @Override
    public void adicionar(Conta conta) {
        contas.add(conta);
    }

    @Override
    public Banco contaPeloTitular(String titular) {
        conta = null;
        for (Conta itm:contas) {
            if (titular.equals(itm.getTitular())) {
                conta = itm;
            }
        }

        Objects.requireNonNull(conta);
        return this;
    }

    @Override
    public void listaSaldos() {
        for(Conta itm:contas) {
            System.out.println(itm);
        }
    }

    @Override
    public void depositar(double valor) {
        Objects.requireNonNull(conta);
        conta.depositar(valor);
    }

    @Override
    public void sacar(double valor) {
        Objects.requireNonNull(conta);
        if (conta.getSaldo() < valor) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        conta.sacar(valor);
    }
}
