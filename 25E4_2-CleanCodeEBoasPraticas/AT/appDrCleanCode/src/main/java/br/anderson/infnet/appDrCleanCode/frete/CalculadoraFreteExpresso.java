package br.anderson.infnet.appDrCleanCode.frete;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public class CalculadoraFreteExpresso implements CalculadoraFreteStrategy {
	private final static double fatorMultiplicador = 1.5;
	private final static double acrescimo = 10;

	@Override
	public boolean suporta(TipoFrete tipo) {
		return TipoFrete.EXP.equals(tipo);
	}

	@Override
	public Entrega calcular(Entrega entrega) {
		double peso = entrega.peso();
		double freteCalculado = peso * fatorMultiplicador + acrescimo;
		
		return entrega.withValorFrete(freteCalculado);
	}
	
}
