package br.anderson.infnet.crud.core;

import br.anderson.infnet.crud.entity.Cliente;
import br.anderson.infnet.crud.service.ClienteService;

import java.util.List;

public class MenuPrincipalItemListar implements MenuPrincipalItem{
    private final ClienteService clienteService;

    public MenuPrincipalItemListar(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @Override
    public String nome() {
        return "Listar Clientes Cadastrados";
    }

    @Override
    public void executar() {
        List<Cliente> clientes = clienteService.listar();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
