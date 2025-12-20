package br.anderson.infnet.appPbTp2;

//import br.anderson.infnet.appDr1At.exercicio04.core.BaseTest;
//import br.anderson.infnet.appDr1At.exercicio04.core.ScreenshotExtension;
//import br.anderson.infnet.appDr1At.exercicio04.pages.AccountCreatedPage;
//import br.anderson.infnet.appDr1At.exercicio04.pages.HomePage;
//import br.anderson.infnet.appDr1At.exercicio04.pages.LoginSignUpPage;
//import br.anderson.infnet.appDr1At.exercicio04.pages.SignUpPage;
import br.anderson.infnet.appPbTp2.core.BaseTest;
import br.anderson.infnet.appPbTp2.core.ScreenshotExtension;
import br.anderson.infnet.appPbTp2.pages.AccountCreatedPage;
import br.anderson.infnet.appPbTp2.pages.HomePage;
import br.anderson.infnet.appPbTp2.pages.LoginSignUpPage;
import br.anderson.infnet.appPbTp2.pages.SignUpPage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ScreenshotExtension.class)
class WebDriverTest extends BaseTest {
	private final String email = "teste@teste2025.com";
	private final String senha = "Www@1234";

	@Test
	@Order(1)
	void logarComCredenciaisInválidas() {
		LoginSignUpPage loginSignUpPage = new LoginSignUpPage(driver, Duration.ofSeconds(20));

		loginSignUpPage.abrir().logar("teste@teste.com", "123456");

		String error = loginSignUpPage.getError();
		assertThat(error).isNotNull();
		assertThat(error).isEqualToIgnoringCase("Your email or password is incorrect!");
	}

	@Test
	@Order(2)
	void registro() {
		LoginSignUpPage loginSignUpPage = new LoginSignUpPage(driver, Duration.ofSeconds(10));

		SignUpPage signupPage = loginSignUpPage.abrir().iniciarRegistro("Teste", email);
		AccountCreatedPage accountCreatedPage = signupPage.preencherDadosConta(senha, 1, 1, 2000)
				.preenhcerEndereco(
						"Clclano",
						"Da Silva",
						"Empresa do Fulano",
						"Rua 0",
						"Rua 2",
						"United States",
						"Florida",
						"Miami",
						"24000",
						"555777888")
				.criarConta();

		assertThat(signupPage.isOn()).isFalse();
		assertThat(accountCreatedPage.isOn()).isTrue();
	}

	@Test
	@Order(3)
	void logarComCredenciaisValidas() {
		LoginSignUpPage loginSignUpPage = new LoginSignUpPage(driver, Duration.ofSeconds(20));

		HomePage homePage = loginSignUpPage.abrir().logar(email, senha);

		assertThat(loginSignUpPage.isOn()).isFalse();
		assertThat(homePage.isOn()).isTrue();

		homePage.deletarConta();
	}
}
