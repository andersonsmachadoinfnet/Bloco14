package br.anderson.infnet.exemplo07.model;

public class Conta implements ContaOperacao {
    private String titular;
    private double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void depositar(double valor) {
        if (valor<0.00) {
            throw new IllegalArgumentException("Valor inválido na operação!");
        }
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (valor<0.00) {
            throw new IllegalArgumentException("Valor inválido na operação!");
        }
        saldo -= valor;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
