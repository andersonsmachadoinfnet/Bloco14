package br.anderson.infnet.appDrCleanCode.frete;

import java.util.List;

import br.anderson.infnet.appDrCleanCode.frete.exception.FreteInvalidoException;

public class CalculadoraFreteStrategyResolverImpl implements CalculadoraFreteStrategyResolver {
	private final List<CalculadoraFreteStrategy> strategies;

	public CalculadoraFreteStrategyResolverImpl(CalculadoraFreteStrategy ...strategies) {
		this.strategies = List.of(strategies);
	}

	@Override
	public CalculadoraFreteStrategy resolver(TipoFrete tipo) {
		return strategies.stream().filter(stragegy -> stragegy.suporta(tipo)).findFirst().orElseThrow(FreteInvalidoException::new);
	}
}
