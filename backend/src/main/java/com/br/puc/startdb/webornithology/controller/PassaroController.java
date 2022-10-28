package com.br.puc.startdb.webornithology.controller;

import com.br.puc.startdb.webornithology.model.Passaro;
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
//@RequiredArgsConstructor
public class PassaroController {

    @Autowired
    PassaroRepository passaroRepository;

    @GetMapping("/list")
    public List<Passaro> listaBirds(){
        return passaroRepository.findAll();
    }

    @GetMapping("")
    public Passaro getPrimeiroPassaro(){
        return passaroRepository.findByNome("teste");
    }

    @GetMapping("/get/nome/{nome}")
    public Passaro pesquisarpassaroPorNome(@PathVariable(value = "nome")String nome){
        return passaroRepository.findByNome(nome);
    }

    @GetMapping("/get/familia/{familia}")
    public Passaro pesquisarpassaroPorFamilia(@PathVariable(value = "familia")String familia){
        return passaroRepository.findByFamilia(familia);
    }

    @GetMapping("/get/nomeingles/{nomeIngles}")
    public Passaro pesquisarpassaroPorNomeIngles(@PathVariable(value = "nomeIngles")String nomeIngles){
        return passaroRepository.findByNomeIngles(nomeIngles);
    }
    @GetMapping("/get/nomelatin/{nomeLatin}")
    public Passaro pesquisarpassaroPorNomeLatin(@PathVariable(value = "nomeLatin")String nomeLatin){
        return passaroRepository.findByNomeLatin(nomeLatin);
    }

    @PostMapping("/create")
    public Passaro salvarPassarp(@RequestBody Passaro passaro){
        return  passaroRepository.save(passaro);
    }

    @PutMapping("/edit")
    public Passaro atualizarPassarp(@RequestBody Passaro passaro){
        return  passaroRepository.save(passaro);
    }

    @DeleteMapping("/del")
    public void deletarPassaro(@RequestBody Passaro passaro){
        passaroRepository.delete(passaro);
    }

//    @DeleteMapping("/del/nome/{nome}")
//    public Passaro deletarPassaroPeloNome(@PathVariable (value = "nome") String nome){
//        passaroRepository.deleteByNome(nome);
//    }

    @DeleteMapping("/del/id/{id}")
    public Passaro pesquisarpassaroPorId(@PathVariable(value = "id")long id){
        return passaroRepository.deleteById(id);
    }



//    @Autowired
//    private final PassaroService service;
//    @Autowired
//    private final PassaroConverterImpl converter;
//
//    @GetMapping("/list")
//    public ResponseEntity<Response> findAll() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(3);
//
//        return ResponseEntity.ok(
//                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("passaros",
//                                service.findAll(30).stream().map(converter::convert).toList()))
//                        .message("Passaros avistados").status(OK).statusCode(OK.value()).build()
//        );
//    }
//
//    @GetMapping("/get/nome/{nome}")
//    public ResponseEntity<Response> getPassaroByName(@PathVariable("nome") String nome) {
//        return ResponseEntity.ok(
//                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("nome",
//                                converter.convert(service.findByName(nome))))
//                        .message("Retornando passaro com respectivo nome")
//                        .status(FOUND).statusCode(FOUND.value()).build()
//        );
//    }
//
//    @GetMapping("/get/nomeIngles/{nome}")
//    public ResponseEntity<Response> getPassaroByNomeIngles(@PathVariable("nome") String nome){
//        return ResponseEntity.ok(
//                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("nome",
//                                converter.convert(service.findByNameIngles(nome))))
//                        .message("Retornando passaro com respectivo nome em ingles")
//                        .status(FOUND).statusCode(FOUND.value()).build()
//        );
//    }
//
//    @GetMapping("/get/nomeLatin/{nomeLatin}")
//    public ResponseEntity<Response> getPassaroByNameLatin(@PathVariable("nomeLatin") String nomeLatin){
//        return ResponseEntity.ok(
//                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("nomeLatin",
//                                converter.convert(service.findByNameLatin(nomeLatin))))
//                        .message("Retornando passaro com respectivo nome em Latin")
//                        .status(FOUND).statusCode(FOUND.value()).build()
//        );
//    }
//
//    @GetMapping("/get/familia/{familia}")
//    public ResponseEntity<Response> getPassaroByFamilia(@PathVariable("familia") String familia) {
//        return ResponseEntity.ok(
//                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("familia",
//                                converter.convert(service.findByFamilia(familia))))
//                        .message("Retornando passaros da familia digitada")
//                        .status(FOUND).statusCode(FOUND.value()).build()
//        );
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Response> createPassaro(@RequestBody @Valid PassaroRequest passaro) {
//        return ResponseEntity.ok(
//                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("passaro",
//                                service.create(converter.convert(passaro))))
//                        .message("Passaro criado")
//                        .status(CREATED).statusCode(CREATED.value()).build()
//        );
//    }


}
