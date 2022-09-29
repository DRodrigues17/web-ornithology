package com.br.puc.startdb.webornithology.controller;

import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.model.Response;
import com.br.puc.startdb.webornithology.service.PassaroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("v1/passaro")
@RequiredArgsConstructor
public class PassaroController {

    @Autowired
    private final PassaroService service;

    @GetMapping("/list")
    public ResponseEntity<Response> findAll(){
        return ResponseEntity.ok(
                Response.builder().timestamp(now()).data(of("servers", service.findAll(30)))
                        .message("Passaros avistados").status(OK).statusCode(OK.value()).build()
        );
    }
    @GetMapping("/get/nome/{nome}")
    public ResponseEntity<Response> getPassaroByName(@PathVariable("nome") String nome){
        return ResponseEntity.ok(
                Response.builder().timestamp(now()).data(of("nome", service.findByName(nome)))
                        .message("Retornando passaro com respectivo nome")
                        .status(OK).statusCode(OK.value()).build()
        );
    }
    @GetMapping("/get/{nomeLatin}")
    public ResponseEntity<Response> getPassaroByNameLatin(@PathVariable("nomeLatin") String nomeLatin){
        return ResponseEntity.ok(
                Response.builder().timestamp(now()).data(of("nomeLatin", service.findByNameLatin(nomeLatin)))
                        .message("Retornando passaro com respectivo nome em Latin")
                        .status(OK).statusCode(OK.value()).build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePassaro(@RequestBody @Valid Passaro passaro) {
        return ResponseEntity.ok(
                Response.builder().timestamp(now()).data(of("passaro", service.create(passaro)))
                        .message("Passaro criado")
                        .status(CREATED).statusCode(CREATED.value()).build()
        );
    }

}
