package br.anderson.infnet.appdr1tp2;

import br.anderson.infnet.appdr1tp2.exercicio03.OrderService;
import br.anderson.infnet.appdr1tp2.exercicio03.PaymentProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Exercicio03OrderServiceTest {
    private PaymentProcessor paymentProcessorMock;
    private final Double VR_LIMITE_AUTORIZADO = 100.00;

    @BeforeEach
    public void setUp() {
        paymentProcessorMock = Mockito.mock(PaymentProcessor.class);
        Mockito.when(paymentProcessorMock.processPayment(ArgumentMatchers.anyDouble())).thenAnswer(invocation->{
            Double amount = (Double) invocation.getArguments()[0];
            return amount<=VR_LIMITE_AUTORIZADO ? Boolean.TRUE : Boolean.FALSE;
        });
    }

    @Test
    void testaSubstituicaoDependenciaPorMock() {
        Double amount = VR_LIMITE_AUTORIZADO;
        OrderService orderService = new OrderService(paymentProcessorMock);
        assertThat(orderService.processOrder(amount)).isEqualTo(true);
    }

    @Test
    void testaPagamentoAprovado() {
        Double amount = VR_LIMITE_AUTORIZADO / 2;
        OrderService orderService = new OrderService(paymentProcessorMock);
        assertThat(orderService.processOrder(amount)).isEqualTo(true);
    }

    @Test
    void testaPagamentoReprovado() {
        Double amount = VR_LIMITE_AUTORIZADO + 0.01;
        OrderService orderService = new OrderService(paymentProcessorMock);
        assertThat(orderService.processOrder(amount)).isEqualTo(false);
    }
}
