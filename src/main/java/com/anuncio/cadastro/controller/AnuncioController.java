package com.anuncio.cadastro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import com.anuncio.cadastro.entidades.Anuncio;
import com.anuncio.cadastro.repositorios.AnuncioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.anuncio.cadastro.services.RelatorioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/anuncio" })
public class AnuncioController {

    @Autowired
    private RelatorioService relatorioService;

    @Autowired
    private AnuncioRepositorio anuncioRepo;

    private List<Anuncio> anuncio;

    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<Anuncio> adicionaAnuncio(@RequestBody @Valid Anuncio anuncio) {
        try {
            Anuncio anuncioData = relatorioService.postRelatorio(anuncio);
            return (ResponseEntity<Anuncio>) new ResponseEntity(anuncioData, HttpStatus.CREATED);
        } catch (Exception e) {
            return (ResponseEntity<Anuncio>) new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/buscaCliente")
    public ResponseEntity<Anuncio> relatorioPorCliente(@RequestParam("cliente") String cliente) {
        Anuncio anuncio = anuncioRepo.findByCliente(cliente).get();

        return new ResponseEntity<>(anuncio, HttpStatus.OK);
    }

    @RequestMapping("/buscaData")
    public ResponseEntity<List<Anuncio>> buscaPorData(
            @RequestParam("data_inicio") @DateTimeFormat(pattern = "dd/MM/yyyy") Date data_inicio,
            @RequestParam("data_termino") @DateTimeFormat(pattern = "dd/MM/yyyy") Date data_termino) {

        anuncio = anuncioRepo.findByData(data_inicio, data_termino).get();

        return new ResponseEntity<List<Anuncio>>((List<Anuncio>) anuncio, HttpStatus.OK);

    }

}