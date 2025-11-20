package br.anderson.infnet.exercicio05.model;

public class Conta implements ContaOperacao{
    private String titular;
    private Double saldo;

    public Conta(Double saldo, String titular) {
        this.saldo = saldo;
        this.titular = titular;
    }

    public void depositar(Double valor) {
        saldo += valor;
    }

    public void sacar(Double valor) {
        if (saldo < valor) {
            throw new RuntimeException("Saldo insuficiente");
        }
        saldo -= valor;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
