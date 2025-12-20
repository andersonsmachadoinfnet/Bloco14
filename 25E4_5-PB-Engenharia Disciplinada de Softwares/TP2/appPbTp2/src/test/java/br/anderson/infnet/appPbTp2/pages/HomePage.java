package br.anderson.infnet.appPbTp2.pages;

import br.anderson.infnet.appPbTp2.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage extends BasePage<HomePage> {
	private final static String URL = "https://automationexercise.com/";
	private final By deletarContaLink = By.cssSelector("a[href='/delete_account'");
	
	public HomePage(WebDriver driver, Duration duration) {
		super(driver, duration, URL);
	}

	public void deletarConta() {
		click(deletarContaLink);
	}
}
