package br.anderson.infnet.appDrCleanCode.frete;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

class CalculadoraFreteExpressoTest {

	private final CalculadoraFreteStrategy calculadora = new CalculadoraFreteExpresso();

	private Entrega entregaComPeso(double peso) {
		return Entrega.criarSemFreteCalculado(
				"Fulano",
				"Rua 0",
				peso,
				TipoFrete.EXP);
	}

	@ParameterizedTest
	@DisplayName("Deve calcular frete expresso proporcional ao peso com acréscimo fixo")
	@CsvSource({
			"0.01,  10.015",
			"5.0,   17.5",
			"10.0,  25.0",
			"100.0, 160.0"
	})
	void deveCalcularFreteExpresso(double peso, double freteEsperado) {
		Entrega entrega = entregaComPeso(peso);

		Entrega resultado = calculadora.calcular(entrega);

		assertThat(resultado).isNotSameAs(entrega);
		assertThat(resultado.valorFrete().valor())
				.isCloseTo(freteEsperado, within(0.0001));
	}

	@Test
	@DisplayName("Deve suportar apenas frete do tipo EXP")
	void deveSuportarApenasFreteExpresso() {

		for (TipoFrete tipo : TipoFrete.values()) {
			if (tipo == TipoFrete.EXP) {
				assertThat(calculadora.suporta(tipo)).isTrue();
			} else {
				assertThat(calculadora.suporta(tipo)).isFalse();
			}
		}
	}
}
