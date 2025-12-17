package br.anderson.infnet.appDrCleanCode.etiqueta;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;
import br.anderson.infnet.appDrCleanCode.frete.TipoFrete;

@ExtendWith(MockitoExtension.class)
class EtiquetaServiceTest {

	@Mock
	private EtiquetaGenerator gerador;

	@Mock
	private EtiquetaDescriptor descritor;

	@InjectMocks
	private EtiquetaService service;

	private Entrega entregaValida() {
		return Entrega.criarSemFreteCalculado(
				"Fulano",
				"Rua 0",
				5.0,
				TipoFrete.ECO);
	}

	@Test
	@DisplayName("Deve delegar geração da etiqueta ao gerador")
	void deveDelegarGeracaoEtiquetaAoGerador() {
		Entrega entrega = entregaValida();
		String etiquetaGerada = "ETIQUETA GERADA";

		when(gerador.gerar(entrega)).thenReturn(etiquetaGerada);

		String resultado = service.gerarEtiqueta(entrega);

		assertThat(resultado).isEqualTo(etiquetaGerada);
		verify(gerador).gerar(entrega);
		verifyZeroInteractions(descritor);
	}

	@Test
	@DisplayName("Deve delegar geração do resumo do pedido ao descritor")
	void deveDelegarGeracaoResumoAoDescritor() {
		Entrega entrega = entregaValida();
		String resumo = "RESUMO DO PEDIDO";

		when(descritor.descrever(entrega)).thenReturn(resumo);

		String resultado = service.gerarResumoPedido(entrega);

		assertThat(resultado).isEqualTo(resumo);
		verify(descritor).descrever(entrega);
		verifyZeroInteractions(gerador);
	}
}
