package com.example.introwms.Service;

import com.example.introwms.Entity.Localizacao;
import com.example.introwms.Entity.Movimentacao;
import com.example.introwms.Entity.Produto;
import com.example.introwms.Repository.MovimentacaoRepository;
import com.example.introwms.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepo;
    private final MovimentacaoRepository movRepo;

    public ProdutoService(ProdutoRepository produtoRepo, MovimentacaoRepository movRepo) {
        this.produtoRepo = produtoRepo;
        this.movRepo = movRepo;
    }

    public Produto criar(Produto produto) {
        return produtoRepo.save(produto);
    }

    public List<Produto> listar() {
        return produtoRepo.findAll();
    }

    public void entradaDeProduto(Long produtoId, int quantidade) {
        Produto produto = produtoRepo.findById(produtoId).orElseThrow();
        produto.setQuantidade(produto.getQuantidade() + quantidade);

        Movimentacao mov = new Movimentacao();
        mov.setProduto(produto);
        mov.setTipo("ENTRADA");
        mov.setQuantidade(quantidade);
        mov.setDestino(produto.getLocalizacao().getCorredor() + "-" + produto.getLocalizacao().getPrateleira());
        mov.setDataHora(LocalDate.from(LocalDateTime.now()));

        movRepo.save(mov);
        produtoRepo.save(produto);
    }

    public void saidaDeProduto(Long produtoId, int quantidade) {
        Produto produto = produtoRepo.findById(produtoId).orElseThrow();
        if (produto.getQuantidade() < quantidade) {
            throw new RuntimeException("Estoque insuficiente!");
        }
        produto.setQuantidade(produto.getQuantidade() - quantidade);

        Movimentacao mov = new Movimentacao();
        mov.setProduto(produto);
        mov.setTipo("SAIDA");
        mov.setQuantidade(quantidade);
        mov.setOrigem(produto.getLocalizacao().getCorredor() + "-" + produto.getLocalizacao().getPrateleira());
        mov.setDataHora(LocalDate.from(LocalDateTime.now()));

        movRepo.save(mov);
        produtoRepo.save(produto);
    }

    public void movimentarProduto(Long produtoId, String destinoCorredor, String destinoPrateleira) {
        Produto produto = produtoRepo.findById(produtoId).orElseThrow();

        String origem = produto.getLocalizacao().getCorredor() + "-" + produto.getLocalizacao().getPrateleira();

        Localizacao novaLocalizacao = new Localizacao();
        novaLocalizacao.setCorredor(destinoCorredor);
        novaLocalizacao.setPrateleira(destinoPrateleira);

        produto.setLocalizacao(novaLocalizacao);

        Movimentacao mov = new Movimentacao();
        mov.setProduto(produto);
        mov.setTipo("MOVIMENTACAO");
        mov.setOrigem(origem);
        mov.setDestino(destinoCorredor + "-" + destinoPrateleira);
        mov.setQuantidade(produto.getQuantidade());
        mov.setDataHora(LocalDate.from(LocalDateTime.now()));

        movRepo.save(mov);
        produtoRepo.save(produto);
    }
}
