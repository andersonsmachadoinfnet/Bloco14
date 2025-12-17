package br.anderson.infnet.appDrCleanCode.entrega;

public final class ValorFreteCalculado implements ValorFrete {
	private final double valor;

	protected ValorFreteCalculado(double valor) {
		this.valor = valor;
	}

	@Override
	public double valor() {
		return valor;
	}

	@Override
	public boolean isCalculado() {
		return true;
	}

	@Override
	public String formatado() {
		return String.valueOf(valor);
	}
}

