package br.anderson.infnet.appPbTp2.pages;

import br.anderson.infnet.appPbTp2.core.BasePage;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AccountCreatedPage extends BasePage<AccountCreatedPage> {
	private final static String URL = "https://automationexercise.com/account_created";

	public AccountCreatedPage(WebDriver driver, Duration duration) {
		super(driver, duration, URL);
	}
}
