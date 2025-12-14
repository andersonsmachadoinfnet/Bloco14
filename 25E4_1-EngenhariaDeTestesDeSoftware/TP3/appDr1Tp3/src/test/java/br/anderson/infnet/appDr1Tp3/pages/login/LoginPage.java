package br.anderson.infnet.appDr1Tp3.pages.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.anderson.infnet.appDr1Tp3.core.BasePage;

public class LoginPage extends BasePage<LoginPage>{
	private final static String URL = "https://practicetestautomation.com/practice-test-login/";
	private final static String URL_LOGADO = "https://practicetestautomation.com/logged-in-successfully/";
	private final By usuarioInput = By.id("username");
	private final By senhaInput = By.id("password");
	private final By submitButton = By.id("submit");
	private final By deslogarButton = By.cssSelector("a[href='" + URL + "']");
	private final By erroDiv = By.id("error");

	public LoginPage(WebDriver driver, Duration duration) {
		super(driver, duration, URL);
	}
	
	public LoginPage preencherUsuario(String usuario) {
		type(usuarioInput, usuario);
		return this;
	}

	public LoginPage preencherSenha(String senha) {
		type(senhaInput, senha);
		return this;
	}

	public LoginPage submeter() {
		click(submitButton);
		return this;
	}

	public LoginPage fazerLogin() {
		submeter();
		wait.until(ExpectedConditions.urlToBe(URL_LOGADO));

		return this;
	}

	public LoginPage deslogar() {
		click(deslogarButton);

		wait.until(ExpectedConditions.urlToBe(URL));
		return this;
	}

	public String obterMensagemErro() {
		return $(erroDiv).getText();
	}

	public String retornaUrlAtual() {
		return driver.getCurrentUrl();
	}

	public boolean isLogado() {
		return driver.getCurrentUrl().equalsIgnoreCase(URL_LOGADO);
	}
}
