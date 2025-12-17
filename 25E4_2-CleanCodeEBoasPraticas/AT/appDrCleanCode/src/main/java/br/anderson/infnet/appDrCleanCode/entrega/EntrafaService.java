package br.anderson.infnet.appDrCleanCode.entrega;

import br.anderson.infnet.appDrCleanCode.etiqueta.EtiquetaService;
import br.anderson.infnet.appDrCleanCode.frete.CalculadoraFreteStrategyResolver;
import br.anderson.infnet.appDrCleanCode.frete.TipoFrete;
import br.anderson.infnet.appDrCleanCode.promocao.PromocaoPolicyApplier;

public class EntrafaService {
	private final CalculadoraFreteStrategyResolver freteResolver;
	private final PromocaoPolicyApplier promocaoApplier;
	private final EtiquetaService etiquetaService;

	public EntrafaService(CalculadoraFreteStrategyResolver freteResolver, PromocaoPolicyApplier promocaoApplier,
			EtiquetaService etiquetaService) {
		this.freteResolver = freteResolver;
		this.promocaoApplier = promocaoApplier;
		this.etiquetaService = etiquetaService;
	}

	public void finalizarEntrega(String destinatario, String endereco, double peso, TipoFrete tipoFrete) {
		Entrega entrega = new Entrega(destinatario, endereco, peso, tipoFrete, 0);
		Entrega comPromocao = promocaoApplier.aplicar(entrega);
		double valorFrete = freteResolver.resolver(comPromocao.tipoFrete()).calcular(comPromocao.peso());
		Entrega comFrete = new Entrega(destinatario, endereco, peso, tipoFrete, valorFrete);
		etiquetaService.gerarEtiqueta(comFrete);
		etiquetaService.gerarResumoPedido(comFrete);
	}
}
