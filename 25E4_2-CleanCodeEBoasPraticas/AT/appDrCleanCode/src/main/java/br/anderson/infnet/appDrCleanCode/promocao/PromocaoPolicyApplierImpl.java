package br.anderson.infnet.appDrCleanCode.promocao;

import java.util.List;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public class PromocaoPolicyApplierImpl implements PromocaoPolicyApplier {
	private final List<PromocaoPolicy> promocoes;

	public PromocaoPolicyApplierImpl(PromocaoPolicy ...promocoes) {
		this.promocoes = List.of(promocoes);
	}

	@Override
	public Entrega aplicar(Entrega entrega) {
		for(PromocaoPolicy promocao : promocoes) {
			entrega = promocao.aplicar(entrega);
		};

		return entrega;
	}
	
}
