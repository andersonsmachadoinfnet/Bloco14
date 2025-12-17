package br.anderson.infnet.appDrCleanCode.frete;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.anderson.infnet.appDrCleanCode.frete.exception.FreteInvalidoException;

class CalculadoraFreteStrategyResolverImplTest {

	@Test
	@DisplayName("Deve resolver a estratégia que suporta o tipo de frete")
	void deveResolverEstrategiaPorTipo() {
		TipoFrete tipo = TipoFrete.ECO;

		CalculadoraFreteStrategy eco = mock(CalculadoraFreteStrategy.class);
		CalculadoraFreteStrategy pad = mock(CalculadoraFreteStrategy.class);

		when(eco.suporta(tipo)).thenReturn(true);
		when(pad.suporta(tipo)).thenReturn(false);

		CalculadoraFreteStrategyResolver resolver = new CalculadoraFreteStrategyResolverImpl(eco, pad);

		CalculadoraFreteStrategy estrategia = resolver.resolver(tipo);

		assertThat(estrategia).isSameAs(eco);
		verify(eco).suporta(tipo);
		verifyZeroInteractions(pad);
	}

	@Test
	@DisplayName("Deve lançar exceção quando nenhuma estratégia suporta o tipo")
	void deveLancarExcecaoQuandoNenhumaEstrategiaSuporta() {
		TipoFrete tipo = TipoFrete.EXP;

		CalculadoraFreteStrategy eco = mock(CalculadoraFreteStrategy.class);
		CalculadoraFreteStrategy pad = mock(CalculadoraFreteStrategy.class);

		when(eco.suporta(tipo)).thenReturn(false);
		when(pad.suporta(tipo)).thenReturn(false);

		CalculadoraFreteStrategyResolver resolver = new CalculadoraFreteStrategyResolverImpl(eco, pad);

		assertThatThrownBy(() -> resolver.resolver(tipo))
				.isInstanceOf(FreteInvalidoException.class);
	}
}
