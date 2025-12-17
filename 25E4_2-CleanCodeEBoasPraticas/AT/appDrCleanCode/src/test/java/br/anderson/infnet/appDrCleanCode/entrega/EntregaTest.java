package br.anderson.infnet.appDrCleanCode.entrega;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import br.anderson.infnet.appDrCleanCode.entrega.exceptions.DestinatarioNaoInformadoException;
import br.anderson.infnet.appDrCleanCode.entrega.exceptions.EnderecoNaoInformadoException;
import br.anderson.infnet.appDrCleanCode.entrega.exceptions.PesoInvalidoException;
import br.anderson.infnet.appDrCleanCode.frete.TipoFrete;

class EntregaTest {

	private final String destinatario = "Fulano";
	private final String endereco = "Rua 0, Niterói - RJ";
	private final double peso = 5.0;
	private final TipoFrete tipoFrete = TipoFrete.ECO;
	private final double valorFrete = 10.0;

	@Test
	@DisplayName("Deve criar entrega sem frete calculado")
	void deveCriarEntregaSemFreteCalculado() {
		Entrega entrega = Entrega.criarSemFreteCalculado(destinatario, endereco, peso, tipoFrete);

		assertThat(entrega.destinatario()).isEqualTo(destinatario);
		assertThat(entrega.endereco()).isEqualTo(endereco);
		assertThat(entrega.peso()).isEqualTo(peso);
		assertThat(entrega.tipoFrete()).isEqualTo(tipoFrete);
		assertThat(entrega.valorFrete()).isInstanceOf(ValorFreteNaoCalculado.class);
	}

	@Test
	@DisplayName("Deve criar entrega com frete calculado")
	void deveCriarEntregaComFreteCalculado() {
		Entrega entrega = Entrega.criarComFreteCalculado(
				destinatario, endereco, peso, tipoFrete, valorFrete);

		assertThat(entrega.valorFrete()).isInstanceOf(ValorFreteCalculado.class);
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { "", " ", "   " })
	@DisplayName("Deve lançar exceção para destinatário inválido")
	void deveFalharQuandoDestinatarioInvalido(String destinatarioInvalido) {
		assertThatThrownBy(() -> Entrega.criarSemFreteCalculado(
				destinatarioInvalido, endereco, peso, tipoFrete)).isInstanceOf(DestinatarioNaoInformadoException.class);
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { "", " ", "   " })
	@DisplayName("Deve lançar exceção para endereço inválido")
	void deveFalharQuandoEnderecoInvalido(String enderecoInvalido) {
		assertThatThrownBy(() -> Entrega.criarSemFreteCalculado(
				destinatario, enderecoInvalido, peso, tipoFrete)).isInstanceOf(EnderecoNaoInformadoException.class);
	}

	@ParameterizedTest
	@ValueSource(doubles = { 0.0, -0.1, -1.0 })
	@DisplayName("Deve lançar exceção para peso inválido (≤ 0)")
	void deveFalharQuandoPesoInvalido(double pesoInvalido) {
		assertThatThrownBy(() -> Entrega.criarSemFreteCalculado(
				destinatario, endereco, pesoInvalido, tipoFrete)).isInstanceOf(PesoInvalidoException.class);
	}

	@Test
	@DisplayName("Deve aceitar peso no limite válido (> 0)")
	void deveAceitarPesoMinimoValido() {
		Entrega entrega = Entrega.criarSemFreteCalculado(
				destinatario, endereco, 0.0001, tipoFrete);

		assertThat(entrega.peso()).isGreaterThan(0);
	}

	@Test
	@DisplayName("withDestinatario deve retornar nova instância e manter original intacta")
	void withDestinatarioDeveRetornarNovaInstancia() {
		Entrega original = Entrega.criarSemFreteCalculado(destinatario, endereco, peso, tipoFrete);

		Entrega nova = original.withDestinatario("Beltrano");

		assertThat(nova).isNotSameAs(original);
		assertThat(nova.destinatario()).isEqualTo("Beltrano");
		assertThat(original.destinatario()).isEqualTo(destinatario);
	}

	@Test
	@DisplayName("withEndereco deve retornar nova instância e manter original intacta")
	void withEnderecoDeveRetornarNovaInstancia() {
		Entrega original = Entrega.criarSemFreteCalculado(destinatario, endereco, peso, tipoFrete);

		Entrega nova = original.withEndereco("Rua Nova");

		assertThat(nova).isNotSameAs(original);
		assertThat(nova.endereco()).isEqualTo("Rua Nova");
		assertThat(original.endereco()).isEqualTo(endereco);
	}

	@Test
	@DisplayName("withPeso deve retornar nova instância e manter original intacta")
	void withPesoDeveRetornarNovaInstancia() {
		Entrega original = Entrega.criarSemFreteCalculado(destinatario, endereco, peso, tipoFrete);

		Entrega nova = original.withPeso(10);

		assertThat(nova).isNotSameAs(original);
		assertThat(nova.peso()).isEqualTo(10);
		assertThat(original.peso()).isEqualTo(peso);
	}

	@Test
	@DisplayName("withFrete deve retornar nova instância e manter original intacta")
	void withFreteDeveRetornarNovaInstancia() {
		Entrega original = Entrega.criarSemFreteCalculado(destinatario, endereco, peso, tipoFrete);

		Entrega nova = original.withFrete(TipoFrete.EXP);

		assertThat(nova).isNotSameAs(original);
		assertThat(nova.tipoFrete()).isEqualTo(TipoFrete.EXP);
		assertThat(original.tipoFrete()).isEqualTo(tipoFrete);
	}

	@Test
	@DisplayName("withValorFrete deve retornar nova instância e marcar frete como calculado")
	void withValorFreteDeveRetornarNovaInstancia() {
		Entrega original = Entrega.criarSemFreteCalculado(destinatario, endereco, peso, tipoFrete);

		Entrega nova = original.withValorFrete(25);

		assertThat(nova).isNotSameAs(original);
		assertThat(nova.valorFrete()).isInstanceOf(ValorFreteCalculado.class);
		assertThat(original.valorFrete()).isInstanceOf(ValorFreteNaoCalculado.class);
	}
}
