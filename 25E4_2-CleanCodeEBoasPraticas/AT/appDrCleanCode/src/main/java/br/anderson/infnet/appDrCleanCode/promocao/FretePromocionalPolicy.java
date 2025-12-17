package br.anderson.infnet.appDrCleanCode.promocao;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public class FretePromocionalPolicy implements PromocaoPolicy {
	@Override
	public Entrega aplicar(Entrega entrega) {
		double peso = entrega.peso();
		
		if (peso > 10) {
			return entrega.withPeso(peso - 1);
		}

		return entrega;
	}
}
