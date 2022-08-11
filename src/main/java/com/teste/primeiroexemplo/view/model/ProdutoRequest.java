package com.teste.primeiroexemplo.view.model;

/**
 * tipo de dado que se espera receber quando alguém fizer uma requisição para o back-end
 * similar ao ProdutoDTO
 * Quando é feito cadastro, não precisa fornecer ID.
 * Quando é feita a consulta de todos, não precisa de ID
 * Quando é feita uma atualização o ID vai na url
 * Quando é feito uma exclusão o ID vai na url
 */
public class ProdutoRequest {

    private String nome;
    
    private Integer quantidade;
    
    private Double valor;
    
    private String observacao;

    //#region Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
