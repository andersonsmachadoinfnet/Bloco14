package br.anderson.infnet.appDrCleanCode.entrega.exceptions;

public class EnderecoNaoInformadoException extends IllegalArgumentException{
	private static final String ENDERECO_NAO_INFORMADO = "Endereço de entrega não informado.";

	public EnderecoNaoInformadoException() {
		super(ENDERECO_NAO_INFORMADO);
	}
}
