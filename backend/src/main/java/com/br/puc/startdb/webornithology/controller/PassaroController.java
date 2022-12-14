package com.br.puc.startdb.webornithology.controller;

import com.br.puc.startdb.webornithology.converter.PassaroConverter;
import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.model.dto.PassaroResponse;
import com.br.puc.startdb.webornithology.repository.PassaroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.br.puc.startdb.webornithology.converter.impl.PassaroConverterImpl;
import com.br.puc.startdb.webornithology.model.Response;
import com.br.puc.startdb.webornithology.model.dto.PassaroRequest;
import com.br.puc.startdb.webornithology.repository.PassaroRepository;
import com.br.puc.startdb.webornithology.service.PassaroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.springframework.http.HttpStatus.*;


//@CrossOrigin(exposedHeaders = "erros, content-type")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("v1/passaro")
@RequiredArgsConstructor
public class PassaroController {

    private final PassaroService service;
    private final PassaroConverter<Passaro, PassaroResponse, PassaroRequest> converter;

    @GetMapping("/list")
    public ResponseEntity<Response> findAll() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);

        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("passaros",
                                service.findAll(30).stream().map(converter::convert).toList()))
                        .message("Passaros avistados").status(OK).statusCode(OK.value()).build()
        );
    }

    @GetMapping("/get/nome/{nome}")
    public ResponseEntity<Response> getPassaroByName(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("nome",
                                converter.convert(service.findByName(nome))))
                        .message("Retornando passaro com respectivo nome")
                        .status(FOUND).statusCode(FOUND.value()).build()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Response> createPassaro(@RequestBody @Valid PassaroRequest passaro) {
        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("passaro",
                                service.create(converter.convert(passaro))))
                        .message("Passaro criado")
                        .status(CREATED).statusCode(CREATED.value()).build()
        );
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Response> DeletePassaroById(@PathVariable("id") long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("deleted", service.deleteById(id)))
                        .message("O passaro selecionado foi deletado")
                        .status(NO_CONTENT).statusCode(NO_CONTENT.value()).build()
        );
    }
}
