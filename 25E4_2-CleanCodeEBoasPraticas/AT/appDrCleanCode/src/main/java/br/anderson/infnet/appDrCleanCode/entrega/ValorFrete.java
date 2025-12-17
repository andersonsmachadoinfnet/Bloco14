package br.anderson.infnet.appDrCleanCode.entrega;

public sealed interface ValorFrete permits ValorFreteNaoCalculado, ValorFreteCalculado{
	static ValorFrete naoCalculado() {
		return ValorFreteNaoCalculado.INSTANCE;
	}

	static ValorFrete calculado(double valor) {
		return new ValorFreteCalculado(valor);
	}

	public double valor();
	
	public boolean isCalculado();

	public String formatado();
}
