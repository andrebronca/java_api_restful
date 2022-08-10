package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos(){
        // return produtoRepository.obterTodos();
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Integer id){
        //poderia verificar se o id é válido
        //return produtoRepository.obterPorId(id);
        return produtoRepository.findById(id);
    }

    public Produto adicionar(Produto produto){
        //poderia ter uma regra pra validar o produto com determinada regra
        //validar qtd, nome não nulo, nr não negativo, etc
        //return produtoRepository.adicionar(produto, true);
        return produtoRepository.save(produto);
    }

    public void deletar(Integer id){
        // produtoRepository.deletar(id);
        produtoRepository.deleteById(id);
    }

    public Produto atualizar(Integer id, Produto produto){
        if (id > 0){
            produto.setId(id);
            // return produtoRepository.atualizar(produto);
            return produtoRepository.save(produto);
        }
        return null;
    }
}
