package br.anderson.infnet.exemplo11.service;

public class ValidadorCPF {
    public void validar(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("CPF nulo!");
        }
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("Tamanho inválido para o CPF!");
        }
    }
}
