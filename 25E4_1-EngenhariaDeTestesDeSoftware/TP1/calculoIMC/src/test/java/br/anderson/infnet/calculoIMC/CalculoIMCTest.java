package br.anderson.infnet.calculoIMC;

import br.anderson.infnet.calculoIMC.core.CalculoIMC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculoIMCTest {
    private CalculoIMC calculoIMC;

    @BeforeEach
    public void setUp() {
        calculoIMC = new CalculoIMC();
    }

    @Test
    @DisplayName("Testa dados válidos, 70Kg e 1.75m")
    public void testeIMCCalculoValido70Kg175cm() {
        double imc = calculoIMC.calcularPeso(70.0, 1.75);
        Assertions.assertEquals(imc, 22.857142857142858);
        //Assertions.assertTrue(imc==22.857142857142858);
    }

    @Test
    public void testeIMCCalculoInvalido10KgNegativo() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Double peso = -10.0;
                    Double altura = 1.75;
                    Double imc = calculoIMC.calcularPeso(peso, altura);
                }
        );
    }

    @Test
    @DisplayName("Questão 5-Analise de Limites - 0kg")
    public void testaIMCLimite0Kg() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Double peso = 0.00;
                    Double altura = 1.75;
                    Double imc = calculoIMC.calcularPeso(peso, altura);
                }
        );
    }

    @Test
    @DisplayName("Questão 5-Analise de Limites - 500kg")
    public void testaIMCLimite500Kg() {
        Double peso = 500.00;
        Double altura = 1.75;
        Double imc = calculoIMC.calcularPeso(peso, altura);
        Assertions.assertEquals(imc, 163.26530612244898);
    }
}
