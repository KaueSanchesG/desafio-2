package org.main;

import java.util.List;

public class Pedido {
    private String produto;
    private int quantidade;
    private double preco;
    private Cliente cliente;
    private boolean finalizado;

    public Pedido(String produto, int quantidade, double preco, Cliente cliente, boolean finalizado) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.cliente = cliente;
        this.finalizado = finalizado;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
