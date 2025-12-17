package br.anderson.infnet.appDrCleanCode.frete.exception;

public class FreteInvalidoException extends IllegalArgumentException{
	private static final String FRETE_INVALIDO = "Tipo de frete inválido.";

	public FreteInvalidoException() {
		super(FRETE_INVALIDO);
	}
}
