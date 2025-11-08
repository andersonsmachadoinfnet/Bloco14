package br.anderson.infnet.calculoIMC;

import br.anderson.infnet.calculoIMC.core.CalculoIMC;
import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculoIMCJqwikTest {
    @Property
    void imcNuncaDeveSerNegativo(@ForAll @Positive double peso, @ForAll @Positive double altura) {
        CalculoIMC calculoIMC = new CalculoIMC();
        double imc = calculoIMC.calcularPeso(peso, altura);;
        assertThat(imc).isGreaterThanOrEqualTo(0);
    }

    @Property
    void imcValoresExtremosDeAltura(@ForAll @Positive double peso, @ForAll("alturaExtremas") double altura) {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    CalculoIMC calculoIMC = new CalculoIMC();
                    double imc = calculoIMC.calcularPeso(peso, altura);
                }
        );
    }

    @Property
    void testIMCComValoresAleatorios(@ForAll double peso, @ForAll double altura) {
        double imc = peso / (altura * altura);
        assertThat(imc).isGreaterThanOrEqualTo(0);
    }

    @Provide
    Arbitrary<Double> alturaExtremas() {
        return Arbitraries.of(0.1, 400.0);
    }

    @Example
    void imcValorFixoDeAlturaEPeso() {
        CalculoIMC calculoIMC = new CalculoIMC();
        Double peso = 69.7;
        Double altura = 1.71;
        Double imcEsperado = 23.836394104168807;
        Double imcCalc = calculoIMC.calcularPeso(peso, altura);
        assertThat(imcCalc).isEqualTo(imcEsperado);
    }
}
