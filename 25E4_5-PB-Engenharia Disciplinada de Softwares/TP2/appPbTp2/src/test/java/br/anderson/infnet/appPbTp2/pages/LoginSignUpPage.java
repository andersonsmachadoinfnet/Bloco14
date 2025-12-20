package br.anderson.infnet.appPbTp2.pages;


import br.anderson.infnet.appPbTp2.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginSignUpPage extends BasePage<LoginSignUpPage> {
	private final static String URL = "https://automationexercise.com/login";
	private final By registroNomeInput = By.cssSelector("input[data-qa='signup-name']");
	private final By registroEmailInput = By.cssSelector("input[data-qa='signup-email']");
	private final By registroButton = By.cssSelector("button[data-qa='signup-button']");

	// Login
	private final By loginEmailInput = By.cssSelector("input[data-qa='login-email']");
	private final By loginSenhalInput = By.cssSelector("input[data-qa='login-password']");
	private final By loginButton = By.cssSelector("button[data-qa='login-button']");
	private final By erroMensagem = By.cssSelector("p[style='color: red;']");

	public LoginSignUpPage(WebDriver driver, Duration duration) {
		super(driver, duration, URL);
	}

	public SignUpPage iniciarRegistro(String nome, String email) {
		type(registroNomeInput, nome);
		type(registroEmailInput, email);
		click(registroButton);

		return new SignUpPage(driver, duration);
	}

	public HomePage logar(String email, String senha) {
		type(loginEmailInput, email);
		type(loginSenhalInput, senha);
		click(loginButton);

		return new HomePage(driver, duration);
	}

	public String getError() {
		wait.until(ExpectedConditions.presenceOfElementLocated(erroMensagem));
		return $(erroMensagem).getText();
	}
}
