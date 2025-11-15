package br.anderson.infnet.crud.core;

import br.anderson.infnet.crud.entity.Cliente;
import br.anderson.infnet.crud.service.ClienteService;

import java.util.Scanner;

public class MenuPrincipalItemCadastrar implements MenuPrincipalItem{
    private final ClienteService clienteService;

    public MenuPrincipalItemCadastrar(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @Override
    public String nome() {
        return "Cadastrar cliente";
    }

    @Override
    public void executar() {
        Cliente cliente = capturarDados();
        clienteService.incluir(cliente);
    }

    private Cliente capturarDados() {
        Scanner in = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.print("Digite o nome do cliente: ");
        cliente.setNome(in.nextLine());
        System.out.print("Digite a idade do cliente: ");
        cliente.setIdade(in.nextInt());
        return cliente;
    }
}
