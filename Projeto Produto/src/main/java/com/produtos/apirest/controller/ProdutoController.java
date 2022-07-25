package com.produtos.apirest.controller;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value = "Retorna lista de produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @ApiOperation(value = "Retorna um produto unico")
    @GetMapping("/produto/{id}")
    public Optional<Produto> listaProdutoUnico(@PathVariable(value = "id") Long id){
        return produtoRepository.findById(id);
    }

    @ApiOperation(value = "Salva um produto")
    @PostMapping("/produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @ApiOperation(value = "Deleta um produto")
    public void deletaProduto(@PathVariable(value = "id") Long id){
        produtoRepository.deleteById(id);
    }


}
