package br.anderson.infnet.crud.core;

import br.anderson.infnet.crud.entity.Cliente;
import br.anderson.infnet.crud.service.ClienteService;

import java.util.Scanner;

public class MenuPrincipalItemExcluir implements MenuPrincipalItem {
    private final ClienteService clienteService;

    public MenuPrincipalItemExcluir(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @Override
    public String nome() {
        return "Excluir cliente";
    }

    @Override
    public void executar() {
        Cliente cliente = localizar();
        clienteService.excluir(cliente);
        System.out.print(String.format("Cliente %s excluído.", cliente.getNome()));
    }

    private Cliente localizar() {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o ID do cliente: ");
        Integer idCliente = in.nextInt();
        return clienteService.ler(idCliente);
    }
}
