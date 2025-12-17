package br.anderson.infnet.appDrCleanCode.entrega;

public final class ValorFreteNaoCalculado implements ValorFrete{
	protected static final ValorFrete INSTANCE = new ValorFreteNaoCalculado();

	private ValorFreteNaoCalculado() {

	}

	@Override
	public boolean isCalculado() {
		return false;
	}

	@Override
	public double valor() {
		throw new IllegalStateException("Frete ainda não calculado.");
	}

	@Override
	public String formatado() {
		return "NÃO CALCULADO";
	}
}
