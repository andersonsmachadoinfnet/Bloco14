package br.anderson.infnet.appdr1tp2;

import br.anderson.infnet.appdr1tp2.exercicio04.Constantes;
import br.anderson.infnet.appdr1tp2.exercicio04.Customer;
import br.anderson.infnet.appdr1tp2.exercicio04.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Exercicio04CustomerServiceTest {
    private CustomerService cs;
    private Customer customerAgeMin = new Customer(1,"Fulano", Constantes.EMAIL_VALIDO, Constantes.IDADE_MIN, true);
    private Customer customerAgeMax = new Customer(1,"Fulano", Constantes.EMAIL_VALIDO, Constantes.IDADE_MAX, true);
    private Customer customerAgeMinInferior = new Customer(1,"Fulano", Constantes.EMAIL_VALIDO, Constantes.IDADE_MIN-1, true);
    private Customer customerAgeMaxSuperior = new Customer(1,"Fulano", Constantes.EMAIL_VALIDO, Constantes.IDADE_MAX+1, true);

    private Customer customerInactive = new Customer(1,"Fulano", Constantes.EMAIL_VALIDO, Constantes.IDADE_MIN, false);
    private Customer customerEmailValid = new Customer(1,"Fulano", Constantes.EMAIL_VALIDO, Constantes.IDADE_MIN, true);
    private Customer customerEmailInvalidSemArroba = new Customer(1,"Fulano", Constantes.EMAIL_INVALIDO_SEM_ARROBA, Constantes.IDADE_MIN, true);
    private Customer customerEmailInvalidSemDominio = new Customer(1,"Fulano", Constantes.EMAIL_INVALIDO_SEM_DOMINIO, Constantes.IDADE_MIN, true);

    @BeforeEach
    public void setUp() {
        cs = new CustomerService();
    }

    @Test
    public void testaIdadeMinimaAceita(){
        assertThat(cs.registerCustomer(customerAgeMin)).isEqualTo(true);
    }

    @Test
    public void testaIdadeMaximaAceita(){
        assertThat(cs.registerCustomer(customerAgeMax)).isEqualTo(true);
    }

    @Test
    public void testaIdadeMenorQueMinimaSeveSerRecusada(){
        assertThat(cs.registerCustomer(customerAgeMinInferior)).isEqualTo(false);
    }

    @Test
    public void testaIdadeMaiorQueMaximaDeveSerRecusada(){
        assertThat(cs.registerCustomer(customerAgeMaxSuperior)).isEqualTo(false);
    }

    @Test
    public void testaAtualizacaoDeClienteAtivo(){
        assertThat(cs.updateCustomer(customerAgeMin, "Ciclano", Constantes.EMAIL_VALIDO, 50)).isEqualTo(true);
    }

    @Test
    public void testaAtualizacaoDeClienteInativoDeveSerRecusado(){
        assertThat(cs.updateCustomer(customerInactive, "Ciclano", Constantes.EMAIL_VALIDO, 50)).isEqualTo(false);
    }

    @Test
    public void testaExclusaoClienteAtivo(){
        assertThat(cs.deleteCustomer(customerAgeMin)).isEqualTo(true);
    }

    @Test
    public void testaExclusaoClienteInativoDeveSerRecusado(){
        assertThat(cs.deleteCustomer(customerInactive)).isEqualTo(false);
    }

    @Test
    public void testaClienteEmailValido() {
        assertThat(cs.deleteCustomer(customerEmailValid)).isEqualTo(true);
    }

    @Test
    public void testaClienteEmailInvalidoSemArroba() {
        assertThat(cs.registerCustomer(customerEmailInvalidSemArroba)).isEqualTo(false);
    }

    @Test
    public void testaClienteEmailInvalidoSemDominio() {
        assertThat(cs.registerCustomer(customerEmailInvalidSemDominio)).isEqualTo(false);
    }

    @Test
    public void testaCadastroCompletoValido() {
        Customer cadastroCompletoValido = new Customer(1,"Ciclano", "ciclano@hotmail.com", 45, true);
        assertThat(cs.registerCustomer(cadastroCompletoValido)).isEqualTo(true);
    }

}
