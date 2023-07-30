package org.main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Func {
    static Scanner sc = new Scanner(System.in);
    public static int menu(){
        int opc;
        System.out.println("Bem vindo ao sistema de vendas, digite uma das opções abaixo:");
        System.out.print("1 - Realizar pedido\n2 - Cliente\n3 - Sair\n");
        opc = sc.nextInt();
        if (opc == 1){
            System.out.println("Aqui realiza pedidos");
        }else {
            menuCliente(new ArrayList<>());
        }
        return opc;
    }
//    List<Cliente> cliente
    public static int menuCliente(List<Cliente> clienteList){
        int opc;
        System.out.println("<---------- Cliente ---------->");
        System.out.print("1 - Procurar cliente \n2 - Editar cliente\n");
        opc = sc.nextInt();
        if (opc == 1){
            String nome;
            System.out.println("Digite o nome do cliente a procurar:");
            nome=sc.next();
            for (int i=0; i<clienteList.size(); i++)
            if(clienteList.get(i).getNome().equals(nome)){
                        System.out.println("Nome: " + clienteList.get(i).getNome());

                        List<Endereco> enderecos = clienteList.get(i).getEndereco();
                        System.out.println("Endereços:");
                        for (Endereco endereco : enderecos) {
                            System.out.println("- Rua: " + endereco.getRua() + ", Número: " + endereco.getNumero() + "\n");
                        }
            }
        }else {
            System.out.println("Aqui edita cliente");
        }
        return 1;
    }
}
