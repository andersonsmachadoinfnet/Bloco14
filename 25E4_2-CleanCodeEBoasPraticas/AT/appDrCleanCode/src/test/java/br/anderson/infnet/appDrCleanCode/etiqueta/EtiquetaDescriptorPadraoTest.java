package br.anderson.infnet.appDrCleanCode.etiqueta;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;
import br.anderson.infnet.appDrCleanCode.frete.TipoFrete;

class EtiquetaDescriptorPadraoTest {

	@Test
	@DisplayName("Deve descrever etiqueta com frete calculado")
	void deveDescreverEtiquetaComFreteCalculado() {
		String destinatario = "Fulano";
		String endereco = "Rua 0";
		double peso = 5;
		TipoFrete tipoFrete = TipoFrete.ECO;
		double valorFrete = 10.0;

		Entrega entrega = Entrega.criarComFreteCalculado(
				destinatario, endereco, peso, tipoFrete, valorFrete);

		EtiquetaDescriptor descriptor = new EtiquetaDescriptorPadrao();

		String descricao = descriptor.descrever(entrega);

		assertThat(descricao).isEqualTo(
				"Pedido para " + destinatario +
						" com frete tipo " + tipoFrete +
						" no valor de R$" + valorFrete);
	}

	@Test
	@DisplayName("Deve descrever etiqueta com frete não calculado")
	void deveDescreverEtiquetaComFreteNaoCalculado() {
		String destinatario = "Fulano";
		String endereco = "Rua 0";
		double peso = 5;
		TipoFrete tipoFrete = TipoFrete.ECO;

		Entrega entrega = Entrega.criarSemFreteCalculado(
				destinatario, endereco, peso, tipoFrete);

		EtiquetaDescriptor descriptor = new EtiquetaDescriptorPadrao();

		String descricao = descriptor.descrever(entrega);

		assertThat(descricao).isEqualTo(
				"Pedido para " + destinatario +
						" com frete tipo " + tipoFrete +
						" no valor de R$NÃO CALCULADO");
	}
}
