package br.anderson.infnet.appDrCleanCode.entrega;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.anderson.infnet.appDrCleanCode.etiqueta.EtiquetaService;
import br.anderson.infnet.appDrCleanCode.frete.FreteService;
import br.anderson.infnet.appDrCleanCode.frete.TipoFrete;
import br.anderson.infnet.appDrCleanCode.promocao.PromocaoService;

class EntragaServiceTest {

	@Test
	@DisplayName("Deve processar entrega aplicando promoções, calculando frete e gerando etiquetas")
	void deveProcessarEntregaCompleta() {
		FreteService freteService = mock(FreteService.class);
		PromocaoService promocaoService = mock(PromocaoService.class);
		EtiquetaService etiquetaService = mock(EtiquetaService.class);

		EntragaService service = new EntragaService(freteService, promocaoService, etiquetaService);

		String destinatario = "Fulano";
		String endereco = "Rua A";
		double peso = 12.0;
		TipoFrete tipoFrete = TipoFrete.ECO;

		Entrega entregaCriada = Entrega.criarSemFreteCalculado(destinatario, endereco, peso, tipoFrete);
		Entrega entregaComPromocao = entregaCriada.withPeso(11.0);
		Entrega entregaFinal = entregaComPromocao.withValorFrete(20.0);

		when(promocaoService.aplicarPromocoes(any(Entrega.class)))
				.thenReturn(entregaComPromocao);

		when(freteService.calcular(entregaComPromocao))
				.thenReturn(entregaFinal);

		service.processar(destinatario, endereco, peso, tipoFrete);

		verify(promocaoService).aplicarPromocoes(any(Entrega.class));
		verify(freteService).calcular(entregaComPromocao);
		verify(etiquetaService).gerarEtiqueta(entregaFinal);
		verify(etiquetaService).gerarResumoPedido(entregaFinal);

		verifyNoMoreInteractions(
				freteService,
				promocaoService,
				etiquetaService);
	}
}
