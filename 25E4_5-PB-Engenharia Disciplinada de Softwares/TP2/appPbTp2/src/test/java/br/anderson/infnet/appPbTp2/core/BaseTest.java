package br.anderson.infnet.appPbTp2.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.util.List;

public abstract class BaseTest {
	protected WebDriver driver;

	@BeforeAll
	public static void configurarDrive() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void abrirManager() {
		var options = configurarChrom();
		driver = new ChromeDriver(options);
	}

	@AfterEach
	public void encerrarDriver() {
		if (driver != null)
			driver.quit();
	}

	private ChromeOptions configurarChrom() {
		var options = new ChromeOptions();
		options.addArguments(List.of(
		// "--headless",
		// "--disable-notifications",
		// "--no-default-browser-check",
		// "--disable-site-isolation-trials",
		// "--no-experiments",
		// "--ignore-gpu-blacklist",
		// "--ignore-certificate-errors",
		// "--ignore-certificate-errors-spki-list",
		// "--disable-gpu",
		// "--disable-extensions",
		// "--disable-default-apps",
		// "--enable-features=NetworkService",
		// "--disable-setuid-sandbox",
		// "--no-sandbox",
		// // Extras
		// "--disable-webgl",
		// "--disable-threaded-animation",
		// "--disable-threaded-scrolling",
		// "--disable-in-process-stack-traces",
		// "--disable-histogram-customizer",
		// "--disable-gl-extensions",
		// "--disable-composited-antialiasing",
		// "--disable-canvas-aa",
		// "--disable-3d-apis",
		// "--disable-accelerated-2d-canvas",
		// "--disable-accelerated-jpeg-decoding",
		// "--disable-accelerated-mjpeg-decode",
		// "--disable-app-list-dismiss-on-blur",
		// "--disable-accelerated-video-decode"
		));

		return options;
	}

	public String tirarScreenshot(String nomeTeste) {
		String pasta = "screenshots";
		File dir = new File(pasta);

		if (!dir.exists()) {
			dir.mkdirs();
		}

		String nomeArquivo = "/" + nomeTeste + "_" + System.currentTimeMillis() + ".png";
		String caminhoArquivo = pasta + nomeArquivo;

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(caminhoArquivo));
			return caminhoArquivo;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao tirar screenshot", e);
		}
	}
}
