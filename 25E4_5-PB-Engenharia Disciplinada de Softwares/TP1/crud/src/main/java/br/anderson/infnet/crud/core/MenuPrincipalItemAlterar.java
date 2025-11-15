package br.anderson.infnet.crud.core;

import br.anderson.infnet.crud.entity.Cliente;
import br.anderson.infnet.crud.service.ClienteService;

import java.util.Scanner;

public class MenuPrincipalItemAlterar implements MenuPrincipalItem{
    private final ClienteService clienteService;

    public MenuPrincipalItemAlterar(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @Override
    public String nome() {
        return "Alterar dados do Cliente";
    }

    @Override
    public void executar() {
        Cliente cliente = capturarDados( localizar() );
        clienteService.alterar(cliente);
    }

    private Cliente localizar() {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o ID do cliente: ");
        Integer idCliente = in.nextInt();
        return clienteService.ler(idCliente);
    }

    private Cliente capturarDados(Cliente clienteAnt) {
        Scanner in = new Scanner(System.in);
        Cliente cliente = new Cliente();
        cliente.setId(clienteAnt.getId());
        System.out.print(String.format("Digite o novo nome do cliente [%s]: ", clienteAnt.getNome()));
        cliente.setNome(in.nextLine());
        System.out.print("Digite a nova idade do cliente: ");
        cliente.setIdade(in.nextInt());
        return cliente;
    }
}
