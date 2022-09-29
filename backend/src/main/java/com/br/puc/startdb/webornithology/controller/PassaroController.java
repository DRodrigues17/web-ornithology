package com.br.puc.startdb.webornithology.controller;

import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.service.PassaroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/passaro")
@RequiredArgsConstructor
public class PassaroController {

    @Autowired
    private final PassaroService service;

    @GetMapping
    public ResponseEntity<List<Passaro>> findAll(){
        List<Passaro> passaros = service.findAll().stream().toList();
        return (ResponseEntity<List<Passaro>>) passaros;
    }
}
