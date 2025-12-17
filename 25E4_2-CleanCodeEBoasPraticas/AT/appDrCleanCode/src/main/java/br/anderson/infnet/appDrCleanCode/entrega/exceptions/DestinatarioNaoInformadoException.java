package br.anderson.infnet.appDrCleanCode.entrega.exceptions;

public class DestinatarioNaoInformadoException extends IllegalArgumentException{
	private static final String DESTINATARIO_NAO_INFORMADO = "Destinatário não informado";
	
	public DestinatarioNaoInformadoException() {
		super(DESTINATARIO_NAO_INFORMADO);
	}
}
