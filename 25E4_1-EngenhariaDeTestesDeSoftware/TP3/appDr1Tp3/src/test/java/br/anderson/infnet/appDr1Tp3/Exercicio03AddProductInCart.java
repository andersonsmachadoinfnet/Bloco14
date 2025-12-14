package br.anderson.infnet.appDr1Tp3;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import br.anderson.infnet.appDr1Tp3.core.BaseTest;
import br.anderson.infnet.appDr1Tp3.pages.prestashop.ShoppingCartPage;
import br.anderson.infnet.appDr1Tp3.pages.prestashop.CheckoutPage;
import br.anderson.infnet.appDr1Tp3.pages.prestashop.HomePage;
import br.anderson.infnet.appDr1Tp3.pages.prestashop.ProductPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Exercicio03AddProductInCart extends BaseTest {

	@Test
	public void obterProdutos() throws InterruptedException {
		HomePage page = new HomePage(driver, Duration.ofSeconds(30));
		String quantidade = "3";

		ProductPage productPage = page.abrir().alterarParaIframe().selecionarPrimeiroProduto();
		ShoppingCartPage shoppingCartPage = productPage.alterarTamanho("3").alterarQuantidade(quantidade)
				.adicionarAoCarrinho()
				.irParaCarrinho();

		String quantidadeCheckout = shoppingCartPage.retornarQuantidade();
		assertThat(quantidadeCheckout, equalTo(quantidade));
		CheckoutPage checkoutPage = shoppingCartPage.tirarPrint("adicao-carrinho").irParaPagamento();
		checkoutPage.personalInformation().preencherFormulario("Teste", "Java", "teste@java.com", "Www@1234#", "05/01/2000")
				.continuar();
		checkoutPage.addressInformation().preencherFormulario("rua 0", "N: 0", "24000", "Paris", "12345678").confirmar();
		checkoutPage.shippingMethod().confirmarColeta();
		checkoutPage.payment().fazerPedido();
	}
}
