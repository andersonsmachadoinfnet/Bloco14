package br.anderson.infnet.appDrCleanCode.promocao;

import java.util.List;

import br.anderson.infnet.appDrCleanCode.entrega.Entrega;

public class PromocaoService {
	private final List<PromocaoPolicy> promocoes;

	public PromocaoService(PromocaoPolicy ...promocoes) {
		this.promocoes = List.of(promocoes);
	}

	public Entrega aplicarPromocoes(Entrega entrega) {
		for(PromocaoPolicy promocao : promocoes) {
			entrega = promocao.aplicar(entrega);
		};

		return entrega;
	}
	
}
