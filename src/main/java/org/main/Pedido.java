package org.main;

import java.util.List;

public class Pedido {
    private List<Produto> produto;
    private Cliente cliente;
    private boolean finalizado;

    public Pedido() {
    }

    public Pedido(List<Produto> produto, Cliente cliente, boolean finalizado) {
        this.produto = produto;
        this.cliente = cliente;
        this.finalizado = finalizado;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
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
