package br.anderson.infnet.appDr1At.exercicio03;

public record ViaCepResponse(String cep,
		String logradouro,
		String complemento,
		String unidade,
		String bairro,
		String localidade,
		String uf,
		String estado,
		String regiao,
		String ibge,
		String gia,
		String ddd,
		String siafi,
		boolean erro) {
}
