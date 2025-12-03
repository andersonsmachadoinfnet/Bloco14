package br.anderson.infnet.exercicio03;

import java.util.Optional;

public class Pedido {
    private Optional<Cliente> cliente;

    public Pedido(Cliente cliente) {
        this.cliente = Optional.ofNullable(cliente);
    }

    public String getNomeCliente() {
        return cliente.orElse(new Cliente("")).getNome();
    }
}
