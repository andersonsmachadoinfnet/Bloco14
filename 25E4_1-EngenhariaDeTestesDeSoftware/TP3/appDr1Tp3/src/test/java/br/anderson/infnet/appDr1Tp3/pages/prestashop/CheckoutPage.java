package br.anderson.infnet.appDr1Tp3.pages.prestashop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.anderson.infnet.appDr1Tp3.core.BasePage;

public class CheckoutPage extends BasePage<CheckoutPage> {
	private final PersonalInformation personalInformation;
	private final AddressInformation addressInformation;
	private final ShippingMethod shippingMethod;
	private final Payment payment;

	protected CheckoutPage(WebDriver driver, Duration duration, String url) {
		super(driver, duration, url);
		this.personalInformation = new PersonalInformation();
		this.addressInformation = new AddressInformation();
		this.shippingMethod = new ShippingMethod();
		this.payment = new Payment();
	}

	public PersonalInformation personalInformation() {
		return personalInformation;
	}

	public AddressInformation addressInformation() {
		return addressInformation;
	}

	public ShippingMethod shippingMethod() {
		return shippingMethod;
	}

	public Payment payment() {
		return payment;
	}

	public class PersonalInformation {
		private final By customerForm = By.id("customer-form");
		private final By tituloSocialRadioButton = By.cssSelector("input#field-id_gender-1");
		private final By primeiroNomeInput = By.id("field-firstname");
		private final By ultimoNomeInput = By.id("field-lastname");
		private final By emailInput = By.id("field-email");
		private final By senhaInput = By.id("field-password");
		private final By dtNascimentoInput = By.id("field-birthday");
		private final By aceitarTudo = By.cssSelector("input[type='checkbox']");
		private final By continuarButton = By.name("continue");

		public PersonalInformation preencherFormulario(String primeiroNome, String ultimoNome, String email, String senha, String dtNascimento) {
			WebElement form = $(customerForm);
			wait.until(ExpectedConditions.elementToBeClickable(form));
			form.findElement(tituloSocialRadioButton).click();
			type(primeiroNomeInput, primeiroNome);
			type(ultimoNomeInput, ultimoNome);
			type(emailInput, email);
			type(senhaInput, senha);
			type(dtNascimentoInput, dtNascimento);
			form.findElements(aceitarTudo).forEach(el -> el.click());

			return this;
		}

		public void continuar() {
			scrollTo(continuarButton);
			click(continuarButton);
		}
	}
	public class AddressInformation {
		private final By addressForm = By.className("js-address-form");
		private final By enderecoInput = By.id("field-address1");
		private final By complInput = By.id("field-address2");
		private final By codigoPostalInput = By.id("field-postcode");
		private final By cidadeInput = By.id("field-city");
		private final By telefoneInput = By.id("field-phone");
		private final By continuarButton = By.name("confirm-addresses");

		public AddressInformation preencherFormulario(String endereco, String compl, String codigoPostal, String cidade, String telefone) {
			wait.until(ExpectedConditions.presenceOfElementLocated(addressForm));
			type(enderecoInput, endereco);
			type(complInput, compl);
			type(codigoPostalInput, codigoPostal);
			type(cidadeInput, cidade);
			type(telefoneInput, telefone);

			return this;
		}

		public void confirmar() {
			scrollTo(continuarButton);
			click(continuarButton);
		}
	}
	public class ShippingMethod {
		private final By confirmarButton = By.name("confirmDeliveryOption");
		public void confirmarColeta() {
			wait.until(ExpectedConditions.presenceOfElementLocated(confirmarButton));

			click(confirmarButton);
		}
	}
	public class Payment {
		private final By pagmentoOptions = By.className("payment-options");
		private final By condicaoParaAprovarForm = By.id("conditions-to-approve");
		private final By metodoPag = By.id("payment-option-1");
		private final By aceitarPoliticas = By.cssSelector("#conditions_to_approve\\[terms-and-conditions\\]");
		private final By fazerPeditoButton = By.cssSelector("div#payment-confirmation button");

		public void fazerPedido() {
			wait.until(ExpectedConditions.presenceOfElementLocated(pagmentoOptions));
			WebElement elPagamento = $(pagmentoOptions);
			WebElement elCondicaoParaAprovar = $(condicaoParaAprovarForm);
			elPagamento.findElement(metodoPag).click();
			elCondicaoParaAprovar.findElement(aceitarPoliticas).click();

			click(fazerPeditoButton);
		}

	}
}
