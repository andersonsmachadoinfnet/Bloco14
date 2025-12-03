package br.anderson.infnet.exercicio11;

public class PedidoService {
    public void atualizarStatus(StatusPedido status) {
        switch (status) {
            case PENDENTE:
                System.out.println("O pedido está pendente.");
                break;

            case PROCESSANDO:
                System.out.println("O pedido está sendo processado.");
                break;

            case ENVIADO:
                System.out.println("O pedido foi enviado.");
                break;

            case ENTREGUE:
                System.out.println("O pedido foi entregue.");
                break;
        }
    }
}
