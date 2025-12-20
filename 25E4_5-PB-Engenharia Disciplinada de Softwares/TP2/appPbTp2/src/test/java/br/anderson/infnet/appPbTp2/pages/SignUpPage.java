package br.anderson.infnet.appPbTp2.pages;

import br.anderson.infnet.appPbTp2.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SignUpPage extends BasePage<SignUpPage> {
	private final static String URL = "https://automationexercise.com/signup";
	private final By generoInput = By.id("id_gender1");
	private final By senhaInput = By.cssSelector("input[data-qa='password']");
	private final By diaSelect = By.cssSelector("select[data-qa='days'");
	private final By mesSelect = By.cssSelector("select[data-qa='months'");
	private final By anoSelect = By.cssSelector("select[data-qa='years'");
	private final By noticiasInput = By.id("newsletter");
	private final By optinInput = By.id("optin");
	private final By primeiroNomeInput = By.cssSelector("input[data-qa='first_name']");
	private final By ultimoNomeInput = By.cssSelector("input[data-qa='last_name']");
	private final By empresaInput = By.cssSelector("input[data-qa='company']");
	private final By enderecoInput = By.cssSelector("input[data-qa='address']");
	private final By endereco2Input = By.cssSelector("input[data-qa='address2']");
	private final By paisSelect = By.cssSelector("select[data-qa='country'");
	private final By estadoInput = By.cssSelector("input[data-qa='state']");
	private final By cidadeInput = By.cssSelector("input[data-qa='city']");
	private final By cepInput = By.cssSelector("input[data-qa='zipcode']");
	private final By celularInput = By.cssSelector("input[data-qa='mobile_number']");
	private final By criarContaButton = By.cssSelector("button[data-qa='create-account']");

	public SignUpPage(WebDriver driver, Duration duration) {
		super(driver, duration, URL);
	}

	public SignUpPage preencherDadosConta(String senha, Integer dia, Integer mes, Integer ano) {
		Select diaSelectElem = new Select($(diaSelect));
		Select mesSelectElem = new Select($(mesSelect));
		Select anoSelectElem = new Select($(anoSelect));

		click(generoInput);
		type(senhaInput, senha);

		diaSelectElem.selectByValue(dia.toString());
		mesSelectElem.selectByValue(mes.toString());
		anoSelectElem.selectByValue(ano.toString());

		click(noticiasInput);
		click(optinInput);

		return this;
	}

	public SignUpPage preenhcerEndereco(
			String primeiroNome,
			String ultimoNome,
			String empresa,
			String endereco,
			String endereco2,
			String pais,
			String estado,
			String cidade,
			String cep,
			String telefone) {
		Select paisSelectElem = new Select($(paisSelect));

		type(primeiroNomeInput, primeiroNome);
		type(ultimoNomeInput, ultimoNome);
		type(empresaInput, empresa);
		type(enderecoInput, endereco);
		type(endereco2Input, endereco2);
		paisSelectElem.selectByValue(pais);
		type(estadoInput, estado);
		type(cidadeInput, cidade);
		type(cepInput, cep);
		type(celularInput, telefone);

		return this;
	}

	public AccountCreatedPage criarConta() {
		click(criarContaButton);

		return new AccountCreatedPage(driver, duration);
	}

}
