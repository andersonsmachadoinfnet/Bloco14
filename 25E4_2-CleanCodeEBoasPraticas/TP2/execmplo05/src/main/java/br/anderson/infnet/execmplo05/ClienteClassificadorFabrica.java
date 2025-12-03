package br.anderson.infnet.execmplo05;

import java.util.ArrayList;
import java.util.List;

public class ClienteClassificadorFabrica {
    public static ClienteClassificador getClassificador() {
        List<ClassificadorStrategy> classificadores = new ArrayList<ClassificadorStrategy>();
        classificadores.add(new ClassificadorStrategyClienteJovemBaixaRendaImpl());
        classificadores.add(new ClassificadorStrategyClientePremiumJovemImpl());
        classificadores.add(new ClassificadorStrategyClientePremiumSeniorImpl());
        classificadores.add(new ClassificadorStrategyClienteRegularJovemImpl());
        classificadores.add(new ClassificadorStrategyClienteRegularSeniorImpl());
        classificadores.add(new ClassificadorStrategyClienteSeniorBaixaRendaImpl());

        return new ClienteClassificador(classificadores);
    }
}
