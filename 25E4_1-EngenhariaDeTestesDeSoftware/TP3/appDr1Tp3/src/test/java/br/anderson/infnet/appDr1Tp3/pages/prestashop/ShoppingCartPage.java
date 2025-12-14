package br.anderson.infnet.appDr1Tp3.pages.prestashop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.anderson.infnet.appDr1Tp3.core.BasePage;

public class ShoppingCartPage extends BasePage<ShoppingCartPage> {
	private final By checkoutContainer = By.className("checkout");
	private final By main = By.cssSelector("section#main");
	private final By quantidadeInput = By.className("js-cart-line-product-quantity");
	protected ShoppingCartPage(WebDriver driver, Duration duration, String url) {
		super(driver, duration, url);
	}

	public String retornarQuantidade() {
		return $(quantidadeInput).getDomAttribute("value");
	}

	public CheckoutPage irParaPagamento() {
		WebElement el = $(checkoutContainer).findElement(By.tagName("a"));
		wait.until(ExpectedConditions.elementToBeClickable(el));
		el.click();

		return new CheckoutPage(driver, duration, url);
	}

	public ShoppingCartPage tirarPrint(String nomeTeste) {
		wait.until(ExpectedConditions.presenceOfElementLocated(main));
		tirarScreenshotElemento($(main), nomeTeste);

		return this;
	}
	
}
