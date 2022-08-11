package com.teste.primeiroexemplo.shared;

/**
 * Identico ao model Produto, não utiliza as anotations do modelo
 * Objeto que será trafegado na controller, o model ficará oculto
 * Este objeto será o de transferência entre a controller e a service
 */
public class ProdutoDTO {

    private Integer id;

    private String nome;
    
    private Integer quantidade;
    
    private Double valor;
    
    private String observacao;

    //#region Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
