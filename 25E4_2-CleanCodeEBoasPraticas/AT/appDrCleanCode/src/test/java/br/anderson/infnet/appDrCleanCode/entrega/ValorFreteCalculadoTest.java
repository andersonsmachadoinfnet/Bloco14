package br.anderson.infnet.appDrCleanCode.entrega;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValorFreteCalculadoTest {

	@Test
	@DisplayName("Deve representar um frete calculado")
	void deveRepresentarFreteCalculado() {
		ValorFrete valorFrete = ValorFrete.calculado(10.0);

		assertThat(valorFrete.isCalculado()).isTrue();
	}

	@Test
	@DisplayName("Deve retornar o valor do frete informado")
	void deveRetornarValorDoFrete() {
		ValorFrete valorFrete = ValorFrete.calculado(25.50);

		assertThat(valorFrete.valor()).isEqualTo(25.50);
	}

	@Test
	@DisplayName("Deve retornar o valor formatado do frete")
	void deveRetornarValorFormatado() {
		ValorFrete valorFrete = ValorFrete.calculado(25.50);

		assertThat(valorFrete.formatado()).isEqualTo("25.5");
	}
}
