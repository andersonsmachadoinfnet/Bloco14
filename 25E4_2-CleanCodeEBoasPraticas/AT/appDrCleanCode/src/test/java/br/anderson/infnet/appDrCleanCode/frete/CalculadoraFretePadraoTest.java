package br.anderson.infnet.appDrCleanCode.frete;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

class CalculadoraFretePadraoTest {

	private final CalculadoraFreteStrategy calculadora = new CalculadoraFretePadrao();

	private Entrega entregaComPeso(double peso) {
		return Entrega.criarSemFreteCalculado(
				"Fulano",
				"Rua 0",
				peso,
				TipoFrete.PAD);
	}

	@ParameterizedTest
	@DisplayName("Deve calcular frete padrão proporcional ao peso")
	@CsvSource({
			"0.01,  0.012",
			"5.0,   6.0",
			"10.0,  12.0",
			"100.0, 120.0"
	})
	void deveCalcularFretePadrao(double peso, double freteEsperado) {
		Entrega entrega = entregaComPeso(peso);

		Entrega resultado = calculadora.calcular(entrega);

		assertThat(resultado).isNotSameAs(entrega);
		assertThat(resultado.valorFrete().valor())
				.isCloseTo(freteEsperado, within(0.0001));
	}

	@Test
	@DisplayName("Deve suportar apenas frete do tipo PAD")
	void deveSuportarApenasFretePadrao() {
		for (TipoFrete tipo : TipoFrete.values()) {
			if (tipo == TipoFrete.PAD) {
				assertThat(calculadora.suporta(tipo)).isTrue();
			} else {
				assertThat(calculadora.suporta(tipo)).isFalse();
			}
		}
	}
}
