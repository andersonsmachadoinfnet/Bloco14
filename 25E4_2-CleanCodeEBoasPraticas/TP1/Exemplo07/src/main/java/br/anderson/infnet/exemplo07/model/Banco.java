package br.anderson.infnet.exemplo07.model;

public interface Banco extends ContaOperacao {
    public void adicionar(Conta conta);
    public Banco contaPeloTitular(String titular);

    public void listaSaldos();
}
