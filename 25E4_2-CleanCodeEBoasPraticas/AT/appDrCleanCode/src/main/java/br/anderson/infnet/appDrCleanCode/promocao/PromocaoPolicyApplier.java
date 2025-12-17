package br.anderson.infnet.appDrCleanCode.promocao;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public interface PromocaoPolicyApplier {
	public Entrega aplicar(Entrega entrega);
}
