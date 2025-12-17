package br.anderson.infnet.appDrCleanCode.promocao;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public interface PromocaoPolicy {
	Entrega aplicar(Entrega entrega);
}
