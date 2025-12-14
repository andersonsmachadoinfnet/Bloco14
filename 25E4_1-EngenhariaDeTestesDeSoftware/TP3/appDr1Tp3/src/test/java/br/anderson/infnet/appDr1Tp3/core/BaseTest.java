package br.anderson.infnet.appDr1Tp3.core;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

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
	public void fecharManager() {
		if (driver != null)
			driver.quit();
	}

	private ChromeOptions configurarChrom() {
		var options = new ChromeOptions();
		options.addArguments(List.of(
		"--headless",
		"--disable-notifications",
		"--no-default-browser-check",
		"--disable-site-isolation-trials",
		"--no-experiments",
		"--ignore-gpu-blacklist",
		"--ignore-certificate-errors",
		"--ignore-certificate-errors-spki-list",
		"--disable-gpu",
		"--disable-extensions",
		"--disable-default-apps",
		"--enable-features=NetworkService",
		"--disable-setuid-sandbox",
		"--no-sandbox",
		// Extras
		"--disable-webgl",
		"--disable-threaded-animation",
		"--disable-threaded-scrolling",
		"--disable-in-process-stack-traces",
		"--disable-histogram-customizer",
		"--disable-gl-extensions",
		"--disable-composited-antialiasing",
		"--disable-canvas-aa",
		"--disable-3d-apis",
		"--disable-accelerated-2d-canvas",
		"--disable-accelerated-jpeg-decoding",
		"--disable-accelerated-mjpeg-decode",
		"--disable-app-list-dismiss-on-blur",
		"--disable-accelerated-video-decode"
		));

		return options;
	}
}
