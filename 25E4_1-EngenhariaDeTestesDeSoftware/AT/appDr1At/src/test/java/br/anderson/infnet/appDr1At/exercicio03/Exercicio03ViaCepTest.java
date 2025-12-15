package br.anderson.infnet.appDr1At.exercicio03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import feign.FeignException;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Exercicio03ViaCepTest {
	@Autowired
	private ViaCepClient viaCepClient;

	@ParameterizedTest(name = "CEP inválido: \"{0}\"")
	@ValueSource(strings = {
			"abcd1234",
			"123",
			"123456789",
			"",
			"vinte-e-quatro"
	})
	@DisplayName("CEP inválido deve gerar erro HTTP")
	void deveFalharParaCepInvalido(String cep) {

		assertThatThrownBy(() -> viaCepClient.buscarPorCep(cep))
				.isInstanceOf(FeignException.class);
	}

	@ParameterizedTest(name = "CEP inexistente: {0}")
	@ValueSource(strings = {
			"00000000",
			"99999999"
	})
	@DisplayName("CEP inexistente deve retornar erro lógico")
	void deveRetornarErroLogicoParaCepInexistente(String cep) {

		ViaCepResponse response = viaCepClient.buscarPorCep(cep);

		assertThat(response.erro()).isTrue();
	}

	@ParameterizedTest(name = "CEP abaixo/acima do limite: {0}")
	@ValueSource(strings = {
			"1234567",
			"123456789"
	})
	@DisplayName("CEP fora do valor limite deve falhar")
	void deveFalharParaCepForaDoLimite(String cep) {

		assertThatThrownBy(() -> viaCepClient.buscarPorCep(cep))
				.isInstanceOf(FeignException.class);
	}

	@ParameterizedTest(name = "CEP válido no limite: {0}")
	@ValueSource(strings = {
			"24020125"
	})
	@DisplayName("CEP válido deve retornar endereço")
	void deveBuscarCepValido(String cep) {
		ViaCepResponse response = viaCepClient.buscarPorCep(cep);

		assertThat(response.uf()).isNotBlank();
	}

	@ParameterizedTest(name = "UF={0}, Cidade={1}, Logradouro={2}")
	@CsvSource({
			"SP, Sao Paulo, Avenida Paulista",
			"SP, São Paulo, Avenida Paulista",
			"RJ, Niteroi, Rua São Sebastião"
	})
	@DisplayName("Consulta por endereço com parâmetros válidos")
	void devePesquisarCepPorEnderecoValido(
			String uf,
			String cidade,
			String logradouro) {
		List<ViaCepResponse> response = viaCepClient.pesquisarCep(uf, cidade, logradouro);

		assertThat(response).isNotEmpty();
	}

	@ParameterizedTest(name = "UF inválida: {0}")
	@ValueSource(strings = { "XX" })
	@DisplayName("UF inválida deve retornar lista vazia")
	void deveFalharParaUfInvalida(String uf) {
		List<ViaCepResponse> response = viaCepClient.pesquisarCep(uf, "Niteroi", "Rua São Sebastião");

		assertThat(response).isEmpty();
	}

	@ParameterizedTest(name = "UF abaixo/acima do limite: {0}")
	@ValueSource(strings = { "R", "RJ1" })
	@DisplayName("UF abaixo/acima do valor limite deve gerar erro HTTP")
	void deveFalharParaUfInvalidaValorLimite(String uf) {
		assertThatThrownBy(() -> viaCepClient.pesquisarCep(uf, "Niteroi", "Rua São Sebastião"))
				.isInstanceOf(FeignException.class);
	}

	@ParameterizedTest(name = "Cidade inválida: {0}")
	@ValueSource(strings = { "Ni" })
	@DisplayName("Cidade abaixo do valor limite deve falhar")
	void deveFalharParaCidadeComMenosDeTresCaracteres(String cidade) {
		assertThatThrownBy(() -> viaCepClient.pesquisarCep("RJ", cidade, "Rua São Sebastião"))
				.isInstanceOf(FeignException.class);
	}

	@ParameterizedTest(name = "Logradouro inválido: {0}")
	@ValueSource(strings = { "Ru" })
	@DisplayName("Logradouro abaixo do valor limite deve falhar")
	void deveFalharParaLogradouroComMenosDeTresCaracteres(String logradouro) {

		assertThatThrownBy(() -> viaCepClient.pesquisarCep("RJ", "Niteroi", logradouro)).isInstanceOf(FeignException.class);
	}

	@ParameterizedTest(name = "Cidade inexistente: {0}")
	@ValueSource(strings = { "CidadeInexistente" })
	@DisplayName("Cidade inexistente deve retornar lista vazia")
	void deveRetornarListaVaziaParaCidadeInexistente(String cidade) {
		List<ViaCepResponse> response = viaCepClient.pesquisarCep("RJ", cidade, "Rua São Sebastião");

		assertThat(response).isEmpty();
	}

	@ParameterizedTest(name = "Logradouro inexistente: {0}")
	@ValueSource(strings = { "Rua Que Nao Existe" })
	@DisplayName("Logradouro inexistente deve retornar lista vazia")
	void deveRetornarListaVaziaParaLogradouroInexistente(String logradouro) {
		List<ViaCepResponse> response = viaCepClient.pesquisarCep("RJ", "Niteroi", logradouro);

		assertThat(response).isEmpty();
	}
}
