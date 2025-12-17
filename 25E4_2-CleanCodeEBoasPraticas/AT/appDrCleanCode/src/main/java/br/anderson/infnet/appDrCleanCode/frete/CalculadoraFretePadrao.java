package br.anderson.infnet.appDrCleanCode.frete;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public class CalculadoraFretePadrao implements CalculadoraFreteStrategy {
	private final static double fatorMultiplicador = 1.2;

	@Override
	public boolean suporta(TipoFrete tipo) {
		return TipoFrete.PAD.equals(tipo);
	}

	@Override
	public Entrega calcular(Entrega entrega) {
		double peso = entrega.peso();
		double freteCalculado = peso * fatorMultiplicador;
		
		return entrega.withValorFrete(freteCalculado);
	}

}
