package org.main;

import java.util.List;

public class Pedido {
    private String produto;
    private int quantidade;
    private double preco;
    private Cliente cliente;

    public Pedido(String produto, int quantidade, double preco, List<Cliente> clienteList) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Cliente cliente() {
        return cliente;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.cliente = cliente;
    }
}
