package br.anderson.infnet.appDr1Tp3.pages.prestashop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.anderson.infnet.appDr1Tp3.core.BasePage;

public class HomePage extends BasePage<HomePage> {
	private final static String URL = "https://demo.prestashop.com/#/en/front";
	private final By primeiroProduto = By.cssSelector("a.product-thumbnail");
	private final By iframe = By.tagName("iframe");


	public HomePage(WebDriver driver, Duration duration) {
		super(driver, duration, URL);
	}

	public HomePage alterarParaIframe() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
		return this;
	}

	public ProductPage selecionarPrimeiroProduto() {
		// click(primeiroProduto);
		scrollUntilVisible(primeiroProduto).click();;

		return new ProductPage(driver, duration, driver.getCurrentUrl());
	}
}
