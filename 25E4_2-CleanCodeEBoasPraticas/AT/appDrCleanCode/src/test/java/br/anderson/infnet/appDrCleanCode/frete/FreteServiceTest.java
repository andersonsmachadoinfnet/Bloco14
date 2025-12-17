package br.anderson.infnet.appDrCleanCode.frete;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

@ExtendWith(MockitoExtension.class)
class FreteServiceTest {

	@Mock
	private CalculadoraFreteStrategyResolver resolver;

	@Mock
	private CalculadoraFreteStrategy strategy;

	@InjectMocks
	private FreteService service;

	@Test
	@DisplayName("Deve delegar o cálculo do frete para a strategy resolvida")
	void deveDelegarCalculoParaStrategy() {
		TipoFrete tipoFrete = TipoFrete.ECO;

		Entrega entregaOriginal = Entrega.criarSemFreteCalculado(
				"Fulano",
				"Rua 0",
				5.0,
				tipoFrete);

		Entrega entregaCalculada = Entrega.criarComFreteCalculado(
				"Fulano",
				"Rua 0",
				5.0,
				tipoFrete,
				10.0);

		when(resolver.resolver(tipoFrete)).thenReturn(strategy);
		when(strategy.calcular(entregaOriginal)).thenReturn(entregaCalculada);

		Entrega resultado = service.calcular(entregaOriginal);

		assertThat(resultado).isSameAs(entregaCalculada);

		verify(resolver).resolver(tipoFrete);
		verify(strategy).calcular(entregaOriginal);
	}
}
