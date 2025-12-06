package br.anderson.infnet.appdr1tp2;

import net.jqwik.api.*;
import static org.assertj.core.api.Assertions.*;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import static br.anderson.infnet.appdr1tp2.exercicio01.ListaFunctions.ordenar;

public class Exercicio01Test {
    @Property
    void tamanhoEhPreservado(@ForAll List<Integer> entrada) {
        List<Integer> resultado = ordenar(entrada);
        assertThat(resultado.size()).isEqualTo(entrada.size());
    }

    @Property
    void resultadoEhOrdenado(@ForAll List<Integer> entrada) {
        List<Integer> resultado = ordenar(entrada);
        for (int i = 0; i < resultado.size() - 1; i++) {
            assertThat(resultado.get(i)).isLessThanOrEqualTo(resultado.get(i + 1));
        }
    }

    @Property
    void mesmosElementos(@ForAll List<Integer> entrada) {
        List<Integer> resultado = ordenar(entrada);
        assertThat(resultado).containsExactlyInAnyOrderElementsOf(entrada);
    }
}
