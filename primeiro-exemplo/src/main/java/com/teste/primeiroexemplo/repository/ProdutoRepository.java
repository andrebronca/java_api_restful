package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiroexemplo.exception.ResourceNotFoundException;
import com.teste.primeiroexemplo.model.Produto;

@Repository
public class ProdutoRepository {
    //simular um bd
    private List<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    public List<Produto> obterTodos(){
        return produtos;
    }

    public Optional<Produto> obterPorId(Integer id){
        return produtos
            .stream()
            .filter(p -> p.getId() == id)
            .findFirst();
    }

    public Produto adicionar(Produto produto, boolean incrementar){
        if(incrementar){
            ultimoId++;
        }
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    public void deletar(Integer id){
        produtos.removeIf(p -> p.getId() == id);
    }

    /**
     * @param produto
     * @return
     */
    public Produto atualizar(Produto produto){
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        
        if (produtoEncontrado.empty() == Optional.empty() ){
            throw new ResourceNotFoundException("Produto não encontrado!");
        }
        deletar(produto.getId());
        adicionar(produto, false);
        return produto;
    }

}
