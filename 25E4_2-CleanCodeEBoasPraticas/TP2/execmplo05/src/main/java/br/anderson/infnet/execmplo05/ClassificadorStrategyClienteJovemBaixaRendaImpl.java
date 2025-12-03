package br.anderson.infnet.execmplo05;

public class ClassificadorStrategyClienteJovemBaixaRendaImpl implements ClassificadorStrategy{
    @Override
    public String classificar(Cliente cliente) {
        return (cliente.getIdade()<=Constantes.SENIOR_IDADE && cliente.getRenda()<=Constantes.JOVEM_RENDA ? "Cliente Jovem Baixa Renda" : "");
    }
}
