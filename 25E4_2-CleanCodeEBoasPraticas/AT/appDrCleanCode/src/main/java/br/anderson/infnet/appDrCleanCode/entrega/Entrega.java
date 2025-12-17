package br.anderson.infnet.appDrCleanCode.entrega;

import br.anderson.infnet.appDrCleanCode.entrega.exceptions.DestinatarioNaoInformadoException;
import br.anderson.infnet.appDrCleanCode.entrega.exceptions.EnderecoNaoInformadoException;
import br.anderson.infnet.appDrCleanCode.entrega.exceptions.PesoInvalidoException;
import br.anderson.infnet.appDrCleanCode.frete.TipoFrete;

public record Entrega(String destinatario, String endereco, double peso, TipoFrete tipoFrete, ValorFrete valorFrete) {
	public Entrega {
		if(destinatario == null || destinatario.isBlank())
			throw new DestinatarioNaoInformadoException();

		if(endereco == null || endereco.isBlank())
			throw new EnderecoNaoInformadoException();

		if(peso <= 0) 
			throw new PesoInvalidoException();
	}

	public Entrega withDestinatario(String destinatario) {
		return new Entrega(destinatario, endereco, peso, tipoFrete, valorFrete);
	}

	public Entrega withEndereco(String endereco) {
		return new Entrega(endereco, endereco, peso, tipoFrete, valorFrete);
	}

	public Entrega withPeso(double peso) {
		return new Entrega(destinatario, endereco, peso, tipoFrete, valorFrete);
	}

	public Entrega withFrete(TipoFrete tipoFrete) {
		return new Entrega(destinatario, endereco, peso, tipoFrete, valorFrete);
	}

	public Entrega withValorFrete(double valorFrete) {
		return new Entrega(destinatario, endereco, peso, tipoFrete, ValorFrete.calculado(valorFrete));
	}

	public static Entrega criarSemFreteCalculado(String destinatario, String endereco, double peso, TipoFrete tipoFrete) {
		return new Entrega(destinatario, endereco, peso, tipoFrete, ValorFrete.naoCalculado());
	}

	public static Entrega criarComFreteCalculado(String destinatario, String endereco, double peso, TipoFrete tipoFrete, double freteCalculado) {
		return new Entrega(destinatario, endereco, peso, tipoFrete, ValorFrete.calculado(freteCalculado));
	}
}
