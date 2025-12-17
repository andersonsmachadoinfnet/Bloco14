package br.anderson.infnet.appDrCleanCode.entrega.exceptions;

public class PesoIgualZeroException extends IllegalArgumentException {
	private static final String PESO_IGUAL_ZERO = "O peso informado deve ser maior que zero.";

	public PesoIgualZeroException() {
		super(PESO_IGUAL_ZERO);
	}

}
