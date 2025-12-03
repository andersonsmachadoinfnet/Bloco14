package br.anderson.infnet.exercicio08;

public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // QUERY – apenas consulta, não altera nada
    public boolean temSaldo(double valor) {
        return saldo >= valor;
    }

    // COMMAND – altera estado (tenta sacar/comprar)
    public boolean debitar(double valor) {
        if (temSaldo(valor)) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    // QUERY – retorna o saldo sem modificar nada
    public double getSaldo() {
        return saldo;
    }
}
