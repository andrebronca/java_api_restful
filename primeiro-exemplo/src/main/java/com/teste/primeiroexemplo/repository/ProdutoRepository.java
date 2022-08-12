package com.teste.primeiroexemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.shared.ProdutoDTO;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    aula 15 parei em 19:37
}
