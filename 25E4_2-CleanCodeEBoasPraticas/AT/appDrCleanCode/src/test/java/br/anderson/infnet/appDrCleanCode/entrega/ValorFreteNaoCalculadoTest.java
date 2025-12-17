package br.anderson.infnet.appDrCleanCode.entrega;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValorFreteNaoCalculadoTest {

	@Test
	@DisplayName("Deve representar um frete não calculado")
	void deveRepresentarFreteNaoCalculado() {
		ValorFrete valorFrete = ValorFrete.naoCalculado();

		assertThat(valorFrete.isCalculado()).isFalse();
	}

	@Test
	@DisplayName("Deve lançar exceção ao tentar obter valor do frete não calculado")
	void deveLancarExcecaoAoAcessarValor() {
		ValorFrete valorFrete = ValorFrete.naoCalculado();

		assertThatThrownBy(valorFrete::valor).isInstanceOf(IllegalStateException.class);
	}

	@Test
	@DisplayName("Deve retornar texto padrão ao formatar frete não calculado")
	void deveRetornarTextoPadraoAoFormatar() {
		ValorFrete valorFrete = ValorFrete.naoCalculado();

		assertThat(valorFrete.formatado()).isEqualTo("NÃO CALCULADO");
	}
}
