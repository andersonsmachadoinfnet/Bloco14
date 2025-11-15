package br.anderson.infnet.crud.core;

import br.anderson.infnet.crud.service.ClienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private List<MenuPrincipalItem> itens;

    public MenuPrincipal(ClienteService clienteService){
        itens = new ArrayList<MenuPrincipalItem>();
        itens.add(new MenuPrincipalItemCadastrar(clienteService));
        itens.add(new MenuPrincipalItemAlterar(clienteService));
        itens.add(new MenuPrincipalItemListar(clienteService));
        itens.add(new MenuPrincipalItemExcluir(clienteService));
    }

    public void apresenta() {
        Scanner in = new Scanner(System.in);
        Integer opcao;

        do {
            apresentaItens();
            opcao = in.nextInt();

            if (opcao >0 && opcao < itens.size()+1) {
                itens.get(opcao-1).executar();
            }

        } while (opcao!=itens.size()+1);

        in.close();
    }

    private void apresentaItens(){
        System.out.println("Menu Principal");
        for (int i = 0; i < itens.size(); i++) {
            System.out.println( String.format("[%d] - %s", (i+1), itens.get(i).nome()) );
        }
        System.out.println( String.format("[%d] - %s", itens.size()+1, "Sair") );
        System.out.print("Informe a opcao desejada: ");
    }
}
