package br.anderson.infnet.appDr1At.exercicio04.core;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class ScreenshotExtension implements TestExecutionExceptionHandler {
	
	@Override
	public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
		Object instance = context.getRequiredTestInstance();

		if (instance instanceof BaseTest testClass) {
			testClass.tirarScreenshot(context.getDisplayName());
		}

		throw throwable;
	}
}
