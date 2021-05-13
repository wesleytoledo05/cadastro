package com.anuncio.cadastro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import com.anuncio.cadastro.entidades.Anuncio;
import org.springframework.beans.factory.annotation.Autowired;
import com.anuncio.cadastro.services.RelatorioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/anuncio" })
public class AnuncioController
{
    @Autowired
    private RelatorioService relatorioService;
    
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<Anuncio> adicionaAnuncio(@RequestBody @Valid Anuncio anuncio) {
        try {
            Anuncio anuncioData = relatorioService.postRelatorio(anuncio);
            return (ResponseEntity<Anuncio>)new ResponseEntity(anuncioData, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return (ResponseEntity<Anuncio>)new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}