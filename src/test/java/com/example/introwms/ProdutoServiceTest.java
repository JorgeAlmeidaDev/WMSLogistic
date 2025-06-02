package com.example.introwms;

import com.example.introwms.Entity.Produto;
import com.example.introwms.Repository.ProdutoRepository;
import com.example.introwms.Service.ProdutoService;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class ProdutoServiceTest {
    @Test
    public void deveRegistrarEntradaDeProduto() {
        ProdutoRepository produtoRepo = mock(ProdutoRepository.class);
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setQuantidade(10);

        when(produtoRepo.findById(1L)).thenReturn(Optional.of(produto));

        ProdutoService service = new ProdutoService(produtoRepo, null);
        service.entradaDeProduto(1L, 5);

        verify(produtoRepo).save(produto);
    }
}
