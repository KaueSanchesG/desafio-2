package org.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Func {
    static Scanner sc = new Scanner(System.in);

    public static int menu(List<Cliente> clienteList) {
        int opc;
        System.out.println("Bem-vindo ao sistema de vendas, digite uma das opções abaixo:");
        System.out.print("1 - Realizar pedido\n2 - Cliente\n3 - Sair\n");
        opc = sc.nextInt();
        if (opc == 1) {
            System.out.println("Aqui realiza pedidos");
        }
        if (opc == 2) {
            menuCliente(clienteList);
        }
        return opc;
    }

    public static List<Cliente> menuCliente(List<Cliente> clienteList) {
        int opc;
        System.out.println("<---------- Cliente ---------->");
        System.out.print("1 - Cadastrar \n2 - Procurar \n3 - Editar\n");
        opc = sc.nextInt();
        switch (opc) {
            case 1 -> {
                System.out.println("Quantos clientes vai adicionar?");
                int i = sc.nextInt();
                for (int contaCliente = 0; contaCliente < i; contaCliente++) {
                    System.out.println("Digite o nome do " + (contaCliente + 1) + "° cliente:");
                    String nome = sc.next();
                    System.out.println("Quantos endereços o " + (contaCliente + 1) + "° cliente possui?");
                    int j = sc.nextInt();
                    List<Endereco> enderecoList = new ArrayList<>();
                    for (int contaEnd = 0; contaEnd < j; contaEnd++) {
                        System.out.println("Endereço " + (j + 1));
                        System.out.println("Digite a rua:");
                        String rua = sc.next();
                        System.out.println("Agora, o numero da casa:");
                        int numero = sc.nextInt();
                        enderecoList.add(new Endereco(rua, numero));
                    }
                    clienteList.add(new Cliente(nome, enderecoList));
                }
            }
            case 2 -> {
                if (!clienteList.isEmpty()) {
                    String nome;
                    System.out.println("Digite o nome do cliente a procurar:");
                    nome = sc.next();
                    for (int i = 0; i < clienteList.size(); i++) {
                        if (clienteList.get(i).getNome().equals(nome)) {
                            System.out.println("Nome: " + clienteList.get(i).getNome());
                            List<Endereco> enderecos = clienteList.get(i).getEndereco();
                            System.out.println("Endereços:");
                            for (Endereco endereco : enderecos) {
                                System.out.println("- Rua: " + endereco.getRua() + ", Número: " + endereco.getNumero() + "\n");
                            }
                        } else {
                            System.out.println("Esse cliente não existe...");
                        }
                    }
                } else {
                    System.out.println("Cadastre um cliente antes para poder procurar...");
                }
            }
            case 3 -> {
                if (!clienteList.isEmpty()) {
                    System.out.println("Digite o nome do cliente a editar");
                    String nome = sc.next();
                    for (int i = 0; i < clienteList.size(); i++)
                        if (nome.equals(clienteList.get(i).getNome())) {
                            System.out.println("Digite o que quer alterar");
                            System.out.println("1 - Nome do cliente\n2 - Endereço do cliente");
                            int opc2 = sc.nextInt();
                            if (opc2 == 1) {
                                System.out.println("Digite o novo nome:");
                                clienteList.get(i).setNome(sc.next());
                            }
                        }
                }
            }
        }
        return clienteList;
    }
}
