package br.anderson.infnet.appDr1Tp3.pages.prestashop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import br.anderson.infnet.appDr1Tp3.core.BasePage;

public class ProductPage extends BasePage<ProductPage> {
	private final By quantidadeInput = By.id("quantity_wanted");
	private final By addAoCarrinhoButton = By.className("add-to-cart");
	private final By tamanhoSelect = By.id("group_1");
	private final By modalCarrinho = By.id("blockcart-modal");
	private final By irParaCarrinhoLink = By.tagName("a");

	protected ProductPage(WebDriver driver, Duration duration, String url) {
		super(driver, duration, url);
	}

	public ProductPage alterarQuantidade(String quantidade) {
		type(quantidadeInput, quantidade);

		return this;
	}

	public ProductPage alterarTamanho(String tamanho) {
		Select selectGroup = new Select($(tamanhoSelect));

		selectGroup.selectByValue(tamanho);
		return this;
	}

	public ProductPage adicionarAoCarrinho() {
		sleep(500);
		click(addAoCarrinhoButton);

		return this;
	}

	public ShoppingCartPage irParaCarrinho() {
		sleep(1000);
		WebElement el = $(modalCarrinho).findElement(irParaCarrinhoLink);
		wait.until(ExpectedConditions.elementToBeClickable(el));

		el.click();

		return new ShoppingCartPage(driver, duration, driver.getCurrentUrl());
	}
}
