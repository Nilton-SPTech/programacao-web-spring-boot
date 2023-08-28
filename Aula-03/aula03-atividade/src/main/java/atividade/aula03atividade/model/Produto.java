package atividade.aula03atividade.model;

public class Produto {
    private String nome;
    private Double preco;
    private Integer qntEstoque;

    public Produto() {}

    public Produto(String nome, Double preco, Integer qntEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQntEstoque() {
        return qntEstoque;
    }

    public void setQntEstoque(Integer qntEstoque) {
        this.qntEstoque = qntEstoque;
    }

    public Double getValorTotalEstoque(){
        return qntEstoque * preco;
    }
}
