package br.anderson.infnet.appDrCleanCode.entrega.exceptions;

public class PesoInvalidoException extends IllegalArgumentException {
	private static final String PESO_INVALIDO = "O peso informado é invalido.";

	public PesoInvalidoException() {
		super(PESO_INVALIDO);
	}

}
