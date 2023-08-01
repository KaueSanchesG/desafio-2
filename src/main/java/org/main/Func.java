package org.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Func {
    static Scanner sc = new Scanner(System.in);

    public static int menu(List<Cliente> clienteList, List<Pedido> pedidos) {
        int opc;
        System.out.println("Bem-vindo ao sistema de vendas, digite uma das opções abaixo:");
        System.out.print("1 - Pedidos\n2 - Cliente\n3 - Sair\n");
        opc = sc.nextInt();
        if (opc == 1) {
            menuPedido(clienteList, pedidos);
        }
        if (opc == 2) {
            menuCliente(clienteList);
        }
        return opc;
    }

    public static void menuCliente(List<Cliente> clienteList) {
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
                        System.out.println("Endereço " + (contaEnd + 1));
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
                            break;
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
                    for (int i = 0; i < clienteList.size(); i++) {
                        if (nome.equals(clienteList.get(i).getNome())) {
                            System.out.println("Digite o que quer alterar");
                            System.out.println("1 - Nome do cliente\n2 - Endereço do cliente");
                            int opc2 = sc.nextInt();
                            if (opc2 == 1) {
                                System.out.println("Digite o novo nome:");
                                clienteList.get(i).setNome(sc.next());
                            }
                            if (opc2 == 2) {
                                for (int conteEnd = 0; conteEnd < clienteList.get(i).getEndereco().size(); conteEnd++) {
                                    System.out.println((conteEnd + 1) + "° - Rua " + clienteList.get(i).getEndereco().get(conteEnd).getRua() + ", " + clienteList.get(i).getEndereco().get(conteEnd).getNumero());
                                }
                                System.out.println("Digite o numero do endereço a ser editado:");
                                int novoEnd = sc.nextInt();
                                System.out.println("Digite a nova rua:");
                                String rua = sc.next();
                                System.out.println("Digite o novo numero:");
                                int numero = sc.nextInt();
                                clienteList.get(i).getEndereco().get(novoEnd - 1).setRua(rua);
                                clienteList.get(i).getEndereco().get(novoEnd - 1).setNumero(numero);
                            }
                        } else {
                            System.out.println("Esse nome não está registrado...");
                        }
                    }
                }
            }
        }
    }

    public static void menuPedido(List<Cliente> clienteList, List<Pedido> pedidos) {
        System.out.println("<---------- Pedidos ---------->");
        System.out.println("Digite uma das opções \n1 - Realizar pedido \n2 - Visualizar pedidos");
        int opc = sc.nextInt();

        if (opc == 1) {
            System.out.println("Digite o nome do cliente a fazer o pedido:");
            String nomeCliente = sc.next();

            Cliente clienteSelecionado = null;
            for (Cliente cliente : clienteList) {
                if (cliente.getNome().equals(nomeCliente)) {
                    clienteSelecionado = cliente;
                    break;
                }
            }

            if (clienteSelecionado != null) {
                System.out.println("Qual a quantidade de produtos a serem adicionados?");
                int qntd = sc.nextInt();
                List<Produto> produtoList = new ArrayList<>();
                for (int i = 0; i < qntd; i++) {
                    System.out.println("Digite o nome do " + (i + 1) + "° produto:");
                    String nome = sc.nextLine();
                    System.out.println("Digite a quantidade do " + (i + 1) + "° produto:");
                    int qntdProd = sc.nextInt();
                    System.out.println("O preço do " + (i + 1) + "° produto:");
                    double preco = sc.nextDouble();
                    produtoList.add(new Produto(nome, qntdProd, preco));
                }

                System.out.println("O pedido foi finalizado?\n\t1 para sim\n\t2 para não\n");
                boolean finalizado = sc.nextInt() == 1 ? true : false;
                pedidos.add(new Pedido(produtoList, clienteSelecionado, finalizado));
            } else {
                System.out.println("Esse cliente não existe...");
            }
        } else if (opc == 2) {
            visualizarPedidos(pedidos);
        }
    }


    public static void visualizarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("<--------------- Sem pedidos ainda --------------->");
        } else {
            System.out.println("<--------------- Pedidos totais --------------->");
            for (Pedido pedido : pedidos) {
                System.out.println("Nome do cliente: " + pedido.getCliente().getNome());
                System.out.println("Pedido finalizado: " + (pedido.isFinalizado() ? "Sim" : "Não"));
                System.out.println("Produtos:");
                for (Produto produto : pedido.getProduto()) {
                    System.out.println("- Nome: " + produto.getNome() + ", Quantidade: " + produto.getQuantidade() + ", Preço: " + produto.getPreco());
                }
                System.out.println("-----------------------------------------");
            }
        }
    }
}
