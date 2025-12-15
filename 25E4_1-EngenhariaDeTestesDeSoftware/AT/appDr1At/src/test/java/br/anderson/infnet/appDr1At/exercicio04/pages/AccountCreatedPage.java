package br.anderson.infnet.appDr1At.exercicio04.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import br.anderson.infnet.appDr1At.exercicio04.core.BasePage;

public class AccountCreatedPage extends BasePage<AccountCreatedPage> {
	private final static String URL = "https://automationexercise.com/account_created";

	public AccountCreatedPage(WebDriver driver, Duration duration) {
		super(driver, duration, URL);
	}
}
