package br.anderson.infnet.appDrCleanCode.frete;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public class FreteService {
	private final CalculadoraFreteStrategyResolver resolver;

	public FreteService(CalculadoraFreteStrategyResolver resolver) {
		this.resolver = resolver;
	}

	public Entrega calcular(Entrega entrega) {
		return resolver.resolver(entrega.tipoFrete()).calcular(entrega);
	}
}
