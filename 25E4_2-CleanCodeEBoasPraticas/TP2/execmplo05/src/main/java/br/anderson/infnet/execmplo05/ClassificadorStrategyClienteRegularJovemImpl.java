package br.anderson.infnet.execmplo05;

public class ClassificadorStrategyClienteRegularJovemImpl implements ClassificadorStrategy {
    @Override
    public String classificar(Cliente cliente) {
        return (cliente.getIdade()<=Constantes.SENIOR_IDADE && cliente.getRenda()>Constantes.JOVEM_RENDA && cliente.getCompas()<=Constantes.JOVEM_COMPRAS ? "Cliente Regular Jovem" : "");
    }
}
