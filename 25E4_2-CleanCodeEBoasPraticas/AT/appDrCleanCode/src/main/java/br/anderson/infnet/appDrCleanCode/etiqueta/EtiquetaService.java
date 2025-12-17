package br.anderson.infnet.appDrCleanCode.etiqueta;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public class EtiquetaService {
	private final EtiquetaGenerator gerador;
	private final EtiquetaDescriptor descritor;

	public EtiquetaService(EtiquetaGenerator gerador, EtiquetaDescriptor descritor) {
		this.gerador = gerador;
		this.descritor = descritor;
	}

	public String gerarEtiqueta(Entrega entrega) {
		return gerador.gerar(entrega);
	}

	public String gerarResumoPedido(Entrega entrega) {
		return descritor.descrever(entrega);
	}
}
