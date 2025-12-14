package br.anderson.infnet.appDr1Tp3.core;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public String tirarScreenshotElemento(WebElement el, String nomeTeste) {
		String pasta = "screenshots";
		File dir = new File(pasta);

		if (!dir.exists()) {
			dir.mkdirs();
		}

		String nomeArquivo = "/" + nomeTeste + "_" + System.currentTimeMillis() + ".png";
		String caminhoArquivo = pasta + nomeArquivo;

		try {
			File src = ((TakesScreenshot) el).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(caminhoArquivo));
			return caminhoArquivo;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao tirar screenshot", e);
		}
	}

}
