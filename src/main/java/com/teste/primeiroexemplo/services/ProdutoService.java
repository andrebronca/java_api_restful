package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.exception.ResourceInternalServerErrorException;
import com.teste.primeiroexemplo.exception.ResourceNotFoundException;
import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;
import com.teste.primeiroexemplo.shared.ProdutoDTO;

/**
 * deixa de recber(usar) Produto (model)
 */
@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> obterTodos(){
        // return produtoRepository.obterTodos();
        //BD retorna uma lista de produto
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(p -> new ModelMapper().map(p, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<ProdutoDTO> obterPorId(Integer id){
        //poderia verificar se o id é válido
        //return produtoRepository.obterPorId(id);
        Optional<Produto> produto = produtoRepository.findById(id);
        if(!produto.isPresent()){
            throw new ResourceNotFoundException("Produto id: "+ id +" não localizado");
        }
        ProdutoDTO produtoDto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        return Optional.of(produtoDto);
    }

    public ProdutoDTO adicionar(ProdutoDTO produtoDto){
        //poderia ter uma regra pra validar o produto com determinada regra
        //validar qtd, nome não nulo, nr não negativo, etc
        //return produtoRepository.adicionar(produto, true);
        //precisa salvar um Produto (model)
        //nesse caso teria que criar um novo objeto e configurar cada propriedade 
        /*
         * Produto produto = new Produto();
         * produto.setId( produtoDto.getId ); 
         */
        //será usado uma classe pra fazer isso automaticamente: modelmapper (pom.xml)

        //remover o ID par fazer o cadastro
        produtoDto.setId(null);

        Produto produto = new ModelMapper().map(produtoDto, Produto.class);
        produto = produtoRepository.save(produto);  //retorna o objeto do BD com o ID

        produtoDto.setId(produto.getId());
        return produtoDto;
    }

    public void deletar(Integer id){
        // produtoRepository.deletar(id);

        Optional<Produto> p = produtoRepository.findById(id);
        // if(p.get() == null){
        if(!p.isPresent()){ //jeito que funciona para enviar a mensagem de erro personalizada
            throw new ResourceNotFoundException("Produto não localizado, id: "+ id);
        }

        produtoRepository.deleteById(id);
    }

    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto){
        produtoDto.setId(id);
        ModelMapper mapper = new ModelMapper();
        Produto produto = mapper.map(produtoDto, Produto.class);
        produtoRepository.save(produto);    //tem id = atualizar, caso contrário = adicionar
        return produtoDto;
    }
}
