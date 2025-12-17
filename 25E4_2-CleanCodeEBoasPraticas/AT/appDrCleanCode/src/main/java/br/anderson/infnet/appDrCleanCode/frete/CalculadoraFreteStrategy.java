package br.anderson.infnet.appDrCleanCode.frete;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public interface CalculadoraFreteStrategy {
	public boolean suporta(TipoFrete tipo);
	public Entrega calcular(Entrega entrega);
}
