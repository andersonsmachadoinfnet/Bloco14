package br.anderson.infnet.execmplo05;

public class ClassificadorStrategyClientePremiumSeniorImpl implements ClassificadorStrategy{
    @Override
    public String classificar(Cliente cliente) {
        return (cliente.getIdade()>Constantes.SENIOR_IDADE && cliente.getRenda()>Constantes.SENIOR_RENDA && cliente.getCompas()>Constantes.SENIOR_COMPRAS ? "Cliente Premium Senior" : "");
    }
}
