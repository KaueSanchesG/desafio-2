package org.main;

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
            menuCliente();
        }
        return opc;
    }
    public static int menuCliente(){
        System.out.println("<---------- Cliente ---------->");
        System.out.print("1 - Procurar cliente \n2 - Editar cliente\n");
        return sc.nextInt();
    }
}
