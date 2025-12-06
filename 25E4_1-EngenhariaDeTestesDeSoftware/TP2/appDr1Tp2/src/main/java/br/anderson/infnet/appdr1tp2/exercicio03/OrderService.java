package br.anderson.infnet.appdr1tp2.exercicio03;

public class OrderService {
    private PaymentProcessor paymentProcessor;

    public OrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public boolean processOrder(double amount) {
        if (paymentProcessor.processPayment(amount)) {
            System.out.println("Pedido confirmado.");
            return true;
        } else {
            System.out.println("Pagamento recusado.");
            return false;
        }
    }
}

