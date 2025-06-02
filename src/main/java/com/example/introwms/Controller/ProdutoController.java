package com.example.introwms.Controller;

import com.example.introwms.Entity.Produto;
import com.example.introwms.Service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.criar(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @PostMapping("/{id}/entrada")
    public void entrada(@PathVariable Long id, @RequestParam int quantidade) {
        produtoService.entradaDeProduto(id, quantidade);
    }
    @PostMapping("/ {id}/saida")
    public void saida(@PathVariable Long id, @RequestParam int quantidade)
    {
        produtoService.saidaDeProduto(id, quantidade);
    }
    @PostMapping("/{id}/movimentar")
    public void movimentar(@PathVariable Long id,
                           @RequestParam String destinoCorredor,
                           @RequestParam String destinoPrateleira) {
        produtoService.movimentarProduto(id, destinoCorredor, destinoPrateleira);
    }

}

