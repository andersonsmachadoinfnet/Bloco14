package br.anderson.infnet.calculoIMC;

import br.anderson.infnet.calculoIMC.core.CalculoIMC;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

public class CalculoIMCMockitoTest {
    @Test
    void testCalculoIMCComMock() {
        CalculoIMC calculoIMC = Mockito.mock(CalculoIMC.class);
        Double peso = 80.00;
        Double altura = 1.80;
        Double imc = 24.69;
        Mockito.when(calculoIMC.calcularPeso(peso, altura)).thenReturn(imc);

        Double imcCalc = calculoIMC.calcularPeso(peso, altura);
        assertThat(imcCalc).isEqualTo(24.69);

    }
}
