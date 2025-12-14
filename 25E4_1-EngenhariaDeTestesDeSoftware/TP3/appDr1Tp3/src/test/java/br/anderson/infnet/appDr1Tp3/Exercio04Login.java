package br.anderson.infnet.appDr1Tp3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import br.anderson.infnet.appDr1Tp3.core.BaseTest;
import br.anderson.infnet.appDr1Tp3.pages.login.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Exercio04Login extends BaseTest {
	
	private LoginPage IniciarEpreencherFormularioLogin(String usuario, String senha) {
		LoginPage page = new LoginPage(driver, Duration.ofSeconds(5));
		page.abrir().preencherUsuario(usuario).preencherSenha(senha);

		return page;
	}

	@ParameterizedTest
	@DisplayName("Deve logar e deslogar")
	@CsvSource({"student, Password123"})
	public void login(String usuario, String senha) {
		

		LoginPage page = IniciarEpreencherFormularioLogin(usuario, senha).fazerLogin();
		assertTrue(page.isLogado());

		page.deslogar();
		assertFalse(page.isLogado());
	}

	@ParameterizedTest
	@DisplayName("Deve apresentar usuario inválido")
	@CsvSource({ "incorrectUser, Password123"})
	public void usuarioIncorreto(String usuario, String senha) {
		LoginPage page = IniciarEpreencherFormularioLogin(usuario, senha).submeter();
		String mensagemErro = page.obterMensagemErro();

		assertThat(mensagemErro, equalTo("Your username is invalid!"));
	}

	@ParameterizedTest
	@DisplayName("Deve apresentar usuario inválido")
	@CsvSource({"student, IncorrectPassword"})
	public void senhaIncorreta(String usuario, String senha) {
		LoginPage page = IniciarEpreencherFormularioLogin(usuario, senha).submeter();
		String mensagemErro = page.obterMensagemErro();

		assertThat(mensagemErro, equalTo("Your password is invalid!"));
	}
}
