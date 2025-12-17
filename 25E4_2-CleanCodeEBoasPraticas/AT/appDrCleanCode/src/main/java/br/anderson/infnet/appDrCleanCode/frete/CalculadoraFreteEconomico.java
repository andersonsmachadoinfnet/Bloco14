package br.anderson.infnet.appDrCleanCode.frete;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public class CalculadoraFreteEconomico implements CalculadoraFreteStrategy {
	private static final double fatorMultiplicador = 1.1;
	private static final double desconto = 5;

	@Override
	public boolean suporta(TipoFrete tipo) {
		return TipoFrete.ECO.equals(tipo);
	}

	@Override
	public Entrega calcular(Entrega entrega) {
		double peso = entrega.peso();
		double freteCalculado = peso * fatorMultiplicador - desconto;;
		
		if (peso < 2 || freteCalculado < 0) {
			freteCalculado = 0;
		}

		return entrega.withValorFrete(freteCalculado);
	}
}
