package com.br.puc.startdb.webornithology.controller;

import com.br.puc.startdb.webornithology.converter.impl.PassaroConverterImpl;
import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.model.Response;
import com.br.puc.startdb.webornithology.model.dto.PassaroRequest;
import com.br.puc.startdb.webornithology.service.PassaroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("v1/passaro")
@RequiredArgsConstructor
public class PassaroController {

    @Autowired
    private final PassaroService service;
    @Autowired
    private final PassaroConverterImpl converter;

    @GetMapping("/list")
    public ResponseEntity<Response> findAll(){

        return ResponseEntity.ok(
                Response.builder().timestamp(now()).data(of("servers", service.findAll(30).stream()
                                .map(converter::convert).collect(Collectors.toList())))
                        .message("Passaros avistados").status(OK).statusCode(OK.value()).build()
        );
    }
    @GetMapping("/get/nome/{nome}")
    public ResponseEntity<Response> getPassaroByName(@PathVariable("nome") String nome){
        return ResponseEntity.ok(
                Response.builder().timestamp(now()).data(of("nome", converter.convert(service.findByName(nome))))
                        .message("Retornando passaro com respectivo nome")
                        .status(FOUND).statusCode(FOUND.value()).build()
        );
    }
    @GetMapping("/get/nomeLatin/{nomeLatin}")
    public ResponseEntity<Response> getPassaroByNameLatin(@PathVariable("nomeLatin") String nomeLatin){
        return ResponseEntity.ok(
                Response.builder().timestamp(now()).data(of("nomeLatin", converter.convert(service.findByNameLatin(nomeLatin))))
                        .message("Retornando passaro com respectivo nome em Latin")
                        .status(FOUND).statusCode(FOUND.value()).build()
        );
    }
    @GetMapping("/get/familia/{familia}")
    public ResponseEntity<Response> getPassaroByFamilia(@PathVariable("familia") String familia){
        return ResponseEntity.ok(
                Response.builder().timestamp(now()).data(of("familia", converter.convert(service.findByFamilia(familia))))
                        .message("Retornando passaros da familia digitada")
                        .status(FOUND).statusCode(FOUND.value()).build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePassaro(@RequestBody @Valid PassaroRequest passaro) {
        return ResponseEntity.ok(
                Response.builder().timestamp(now()).data(of("passaro", service.create(converter.convert(passaro))))
                        .message("Passaro criado")
                        .status(CREATED).statusCode(CREATED.value()).build()
        );
    }

}
