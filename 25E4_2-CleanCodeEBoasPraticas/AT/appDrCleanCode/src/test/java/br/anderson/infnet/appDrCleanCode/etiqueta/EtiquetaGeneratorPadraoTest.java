package br.anderson.infnet.appDrCleanCode.etiqueta;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;
import br.anderson.infnet.appDrCleanCode.frete.TipoFrete;

class EtiquetaGeneratorPadraoTest {

	@Test
	@DisplayName("Deve gerar etiqueta com frete calculado")
	void deveGerarEtiquetaComFreteCalculado() {
		String destinatario = "Fulano";
		String endereco = "Rua 0, Niterói - RJ";
		double peso = 5.0;
		TipoFrete tipoFrete = TipoFrete.ECO;
		double valorFrete = 10.0;

		Entrega entrega = Entrega.criarComFreteCalculado(
				destinatario, endereco, peso, tipoFrete, valorFrete);

		EtiquetaGenerator generator = new EtiquetaGeneratorPadrao();

		String etiqueta = generator.gerar(entrega);

		assertThat(etiqueta).isEqualTo(
				"Destinatário: " + destinatario + "\n" +
						"Endereço: " + endereco + "\n" +
						"Valor do Frete: R$" + valorFrete);
	}

	@Test
	@DisplayName("Deve gerar etiqueta com frete não calculado")
	void deveGerarEtiquetaComFreteNaoCalculado() {
		String destinatario = "Fulano";
		String endereco = "Rua 0, Niterói - RJ";
		double peso = 5.0;
		TipoFrete tipoFrete = TipoFrete.ECO;

		Entrega entrega = Entrega.criarSemFreteCalculado(
				destinatario, endereco, peso, tipoFrete);

		EtiquetaGenerator generator = new EtiquetaGeneratorPadrao();

		String etiqueta = generator.gerar(entrega);

		assertThat(etiqueta).isEqualTo(
				"Destinatário: " + destinatario + "\n" +
						"Endereço: " + endereco + "\n" +
						"Valor do Frete: R$NÃO CALCULADO");
	}
}
