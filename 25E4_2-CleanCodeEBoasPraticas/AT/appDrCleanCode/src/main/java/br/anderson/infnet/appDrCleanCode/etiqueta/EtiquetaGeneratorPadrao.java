package br.anderson.infnet.appDrCleanCode.etiqueta;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public class EtiquetaGeneratorPadrao implements EtiquetaGenerator {

	@Override
	public String gerar(Entrega entrega) {
		return "Destinatário: " + entrega.destinatario() + "\nEndereço: " + entrega.endereco() + "\nValor do Frete: R$"
				+ entrega.valorFrete().formatado();
	}

}
