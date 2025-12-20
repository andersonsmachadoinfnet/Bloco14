package br.anderson.infnet.appPbTp2.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage<P extends BasePage<P>> {
	protected final WebDriver driver;
	protected final WebDriverWait wait;
	protected final String url;
	protected final Duration duration;

	protected BasePage(WebDriver driver, Duration duration, String url) {
		this.driver = driver;
		this.url = url;
		this.duration = duration;
		this.wait = new WebDriverWait(driver, duration);
	}

	@SuppressWarnings("unchecked")
	public P abrir() {
		driver.get(url);

		return (P) this;
	}

	public WebElement $(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public List<WebElement> $$(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return driver.findElements(locator);
	}

	public void click(By locator) {
		WebElement el = $(locator);
		wait.until(ExpectedConditions.elementToBeClickable(el));
		el.click();
	}

	public void type(By locator, String keys) {
		WebElement el = $(locator);
		wait.until(ExpectedConditions.elementToBeClickable(el));
		el.click();
		el.sendKeys(Keys.CONTROL + "a");
		el.sendKeys(keys);
	}

	public WebElement scrollUntilVisible(By locator) {
		int maxScrolls = 20;

		for (int i = 0; i < maxScrolls; i++) {
			try {
				WebElement el = driver.findElement(locator);
				if (el.isDisplayed()) {
					return el;
				}
			} catch (Exception ignored) {
			}

			scrollBy(0, 300);

			sleep(300);
		}

		throw new RuntimeException("Elemento não encontrado na página após rolagem.");
	}

	protected void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignored) {
		}
	}

	public void scrollTo(By locator) {
		WebElement element = $(locator);
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",
						element);
	}

	public void scrollBy(int x, int y) {
		((JavascriptExecutor) driver)
				.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}

	public boolean isOn() {
		return url.equalsIgnoreCase(driver.getCurrentUrl());
	}
}
