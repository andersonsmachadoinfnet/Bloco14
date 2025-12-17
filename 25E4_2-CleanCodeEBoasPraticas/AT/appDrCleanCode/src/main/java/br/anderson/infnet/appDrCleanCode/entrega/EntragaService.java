package br.anderson.infnet.appDrCleanCode.entrega;

import br.anderson.infnet.appDrCleanCode.etiqueta.EtiquetaService;
import br.anderson.infnet.appDrCleanCode.frete.FreteService;
import br.anderson.infnet.appDrCleanCode.frete.TipoFrete;
import br.anderson.infnet.appDrCleanCode.promocao.PromocaoService;

public class EntragaService {
	private final FreteService freteService;
	private final PromocaoService promocaoService;
	private final EtiquetaService etiquetaService;

	public EntragaService(FreteService freteService, 
			PromocaoService promocaoService,
			EtiquetaService etiquetaService) {
		this.freteService    = freteService;
		this.promocaoService = promocaoService;
		this.etiquetaService = etiquetaService;
	}

	public void processar(String destinatario, String endereco, double peso, TipoFrete tipoFrete) {
		Entrega entrega                    = Entrega.criarSemFreteCalculado(destinatario, endereco, peso, tipoFrete);
		Entrega comPromocoes               = promocaoService.aplicarPromocoes(entrega);
		Entrega comPromocaoEFreteCalculado = freteService.calcular(comPromocoes);
		
		etiquetaService.gerarEtiqueta(comPromocaoEFreteCalculado);
		etiquetaService.gerarResumoPedido(comPromocaoEFreteCalculado);
	}
}
