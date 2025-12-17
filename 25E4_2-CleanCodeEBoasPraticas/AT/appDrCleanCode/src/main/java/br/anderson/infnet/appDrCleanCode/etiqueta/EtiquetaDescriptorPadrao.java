package br.anderson.infnet.appDrCleanCode.etiqueta;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public class EtiquetaDescriptorPadrao implements EtiquetaDescriptor {

	@Override
	public String descrever(Entrega entrega) {
		return "Pedido para " + entrega.destinatario() + " com frete tipo " + entrega.tipoFrete() + " no valor de R$"
				+ entrega.valorFrete().formatado();
	}

}
