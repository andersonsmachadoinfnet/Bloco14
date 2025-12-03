package br.anderson.infnet.execmplo05;

public class ClassificadorStrategyClienteSeniorBaixaRendaImpl implements ClassificadorStrategy {
    @Override
    public String classificar(Cliente cliente) {
        return (cliente.getIdade()>Constantes.SENIOR_IDADE && cliente.getRenda()<Constantes.SENIOR_RENDA ? "Cliente Sênior Baixa Renda" : "");
    }
}
