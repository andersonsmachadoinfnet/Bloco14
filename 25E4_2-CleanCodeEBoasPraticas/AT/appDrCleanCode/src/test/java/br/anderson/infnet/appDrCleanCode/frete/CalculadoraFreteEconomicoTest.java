package br.anderson.infnet.appDrCleanCode.frete;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

class CalculadoraFreteEconomicoTest {
	private final CalculadoraFreteStrategy calculadora = new CalculadoraFreteEconomico();

	private Entrega entregaComPeso(double peso) {
		return Entrega.criarSemFreteCalculado(
				"Fulano",
				"Rua 0",
				peso,
				TipoFrete.ECO);
	}

	@ParameterizedTest
	@DisplayName("Deve calcular frete econômico apenas para pesos maiores que 2")
	@CsvSource({
			"1.0,   0.0",
			"2.0,   0.0",
			"2.01,  0.0",
			"5.0,   0.5",
			"10.0,  6.0"
	})
	void deveCalcularFreteEconomico(double peso, double freteEsperado) {
		Entrega entrega = entregaComPeso(peso);

		Entrega resultado = calculadora.calcular(entrega);

		assertThat(resultado).isNotSameAs(entrega);
		assertThat(resultado.valorFrete().valor())
				.isCloseTo(freteEsperado, within(0.001));
	}

	@Test
	@DisplayName("Deve suportar apenas frete do tipo ECO")
	void deveSuportarApenasFreteEco() {
		for (TipoFrete tipo : TipoFrete.values()) {
			if (tipo == TipoFrete.ECO) {
				assertThat(calculadora.suporta(tipo)).isTrue();
			} else {
				assertThat(calculadora.suporta(tipo)).isFalse();
			}
		}
	}
}
