package br.anderson.infnet.appDr1At.exercicio04.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.anderson.infnet.appDr1At.exercicio04.core.BasePage;

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
