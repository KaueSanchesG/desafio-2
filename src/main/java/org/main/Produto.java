package org.main;

public class Produto {
    private String nome;
    private int quantidade;
    private double preco;
    private double totalProduto;

    public Produto(String nome, int quantidade, double preco, double totalProduto) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.totalProduto = totalProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public double getTotalProduto() {
        return totalProduto;
    }

    public void setTotalProduto(double totalProduto) {
        this.totalProduto = totalProduto;
    }
}
