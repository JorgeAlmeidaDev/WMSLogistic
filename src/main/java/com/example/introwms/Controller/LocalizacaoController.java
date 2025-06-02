package com.example.introwms.Controller;

import com.example.introwms.Entity.Localizacao;
import com.example.introwms.Repository.LocalizacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/localizacoes")
public class LocalizacaoController {
    private final LocalizacaoRepository localizacaoRepository;

    public LocalizacaoController(LocalizacaoRepository localizacaoRepository) {
        this.localizacaoRepository = localizacaoRepository;
    }
    @PostMapping
    public Localizacao criar(@RequestBody Localizacao localizacao) {
        return localizacaoRepository.save(localizacao);
    }

    @GetMapping
    public List<Localizacao>listar(){
        return localizacaoRepository.findAll();
    }
}
