package br.anderson.infnet.appDrCleanCode.promocao;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;
import br.anderson.infnet.appDrCleanCode.frete.TipoFrete;

class PromocaoServiceTest {

	@Test
	@DisplayName("Deve aplicar todas as promoções em sequência")
	void deveAplicarPromocoesEmSequencia() {
		Entrega entregaInicial = Entrega.criarSemFreteCalculado(
				"Fulano",
				"Rua A",
				12.0,
				TipoFrete.ECO
		);

		Entrega entregaAposPrimeira = entregaInicial.withPeso(11.0);
		Entrega entregaFinal = entregaAposPrimeira.withPeso(10.0);

		PromocaoPolicy promocao1 = mock(PromocaoPolicy.class);
		PromocaoPolicy promocao2 = mock(PromocaoPolicy.class);

		when(promocao1.aplicar(entregaInicial)).thenReturn(entregaAposPrimeira);
		when(promocao2.aplicar(entregaAposPrimeira)).thenReturn(entregaFinal);

		PromocaoService service = new PromocaoService(promocao1, promocao2);

		Entrega resultado = service.aplicarPromocoes(entregaInicial);

		assertThat(resultado).isSameAs(entregaFinal);

		verify(promocao1).aplicar(entregaInicial);
		verify(promocao2).aplicar(entregaAposPrimeira);
		verifyNoMoreInteractions(promocao1, promocao2);
	}

	@Test
	@DisplayName("Deve retornar a mesma entrega quando não há promoções")
	void deveRetornarMesmaEntregaQuandoNaoHaPromocoes() {
		Entrega entrega = Entrega.criarSemFreteCalculado(
				"Fulano",
				"Rua A",
				8.0,
				TipoFrete.PAD);

		PromocaoService service = new PromocaoService();

		Entrega resultado = service.aplicarPromocoes(entrega);

		assertThat(resultado).isSameAs(entrega);
	}
}
