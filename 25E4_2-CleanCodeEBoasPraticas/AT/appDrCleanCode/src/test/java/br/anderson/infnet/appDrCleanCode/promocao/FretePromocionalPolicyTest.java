package br.anderson.infnet.appDrCleanCode.promocao;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;
import br.anderson.infnet.appDrCleanCode.frete.TipoFrete;

class FretePromocionalPolicyTest {

	private final FretePromocionalPolicy policy = new FretePromocionalPolicy();

	@Test
	@DisplayName("Deve aplicar promoção quando peso for maior que 10")
	void deveAplicarPromocaoQuandoPesoMaiorQueDez() {
		Entrega entregaOriginal = Entrega.criarSemFreteCalculado(
				"Fulano",
				"Rua A",
				11.0,
				TipoFrete.ECO);

		Entrega entregaPromocional = policy.aplicar(entregaOriginal);

		assertThat(entregaPromocional)
				.isNotSameAs(entregaOriginal);

		assertThat(entregaPromocional.peso())
				.isEqualTo(10.0);
	}

	@ParameterizedTest
	@ValueSource(doubles = { 0.1, 5.0, 9.99, 10.0 })
	@DisplayName("Não deve aplicar promoção quando peso for menor ou igual a 10")
	void naoDeveAplicarPromocaoQuandoPesoMenorOuIgualADez(double peso) {
		Entrega entregaOriginal = Entrega.criarSemFreteCalculado(
				"Fulano",
				"Rua A",
				peso,
				TipoFrete.ECO);

		Entrega entregaResultado = policy.aplicar(entregaOriginal);

		assertThat(entregaResultado)
				.isSameAs(entregaOriginal);

		assertThat(entregaResultado.peso())
				.isEqualTo(peso);
	}
}
