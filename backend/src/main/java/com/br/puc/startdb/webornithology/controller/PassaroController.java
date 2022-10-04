package com.br.puc.startdb.webornithology.controller;

import com.br.puc.startdb.webornithology.converter.impl.PassaroConverterImpl;
import com.br.puc.startdb.webornithology.model.Response;
import com.br.puc.startdb.webornithology.model.dto.PassaroRequest;
import com.br.puc.startdb.webornithology.service.PassaroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.time.LocalDateTime;
import java.util.Map;

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
                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("passaros",
                                service.findAll(30).stream().map(converter::convert).toList()))
                        .message("Passaros avistados").status(OK).statusCode(OK.value()).build()
        );
    }
    @GetMapping("/get/nome/{nome}")
    public ResponseEntity<Response> getPassaroByName(@PathVariable("nome") String nome){
        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("nome",
                                converter.convert(service.findByName(nome))))
                        .message("Retornando passaro com respectivo nome")
                        .status(FOUND).statusCode(FOUND.value()).build()
        );
    }
    @GetMapping("/get/nomeLatin/{nomeLatin}")
    public ResponseEntity<Response> getPassaroByNameLatin(@PathVariable("nomeLatin") String nomeLatin){
        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("nomeLatin",
                                converter.convert(service.findByNameLatin(nomeLatin))))
                        .message("Retornando passaro com respectivo nome em Latin")
                        .status(FOUND).statusCode(FOUND.value()).build()
        );
    }
    @GetMapping("/get/familia/{familia}")
    public ResponseEntity<Response> getPassaroByFamilia(@PathVariable("familia") String familia){
        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("familia",
                                converter.convert(service.findByFamilia(familia))))
                        .message("Retornando passaros da familia digitada")
                        .status(FOUND).statusCode(FOUND.value()).build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePassaro(@RequestBody @Valid PassaroRequest passaro) {
        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("passaro",
                                service.create(converter.convert(passaro))))
                        .message("Passaro criado")
                        .status(CREATED).statusCode(CREATED.value()).build()
        );
    }

/**
 * import lombok.extern.slf4j.Slf4j;
 * import org.springframework.beans.factory.annotation.Value;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.http.ResponseEntity;
 * import org.springframework.web.bind.annotation.*;
 * import org.springframework.web.multipart.MultipartFile;
 *
 * import java.nio.file.Files;
 * import java.nio.file.Path;
 * import java.nio.file.StandardCopyOption;
 * import java.util.UUID;
 * @RestController
 * @RequestMapping(value = "/api/upload", produces = {"application/json"})
 * @Slf4j
 * @CrossOrigin("*")
 * public class UploadArquivoController {
 *
 *     private final String pathArquivos;
 *
 *     public UploadArquivoController(@Value("${app.path.arquivos}") String pathArquivos){
 *         this.pathArquivos = pathArquivos;
 *     }
 *
 *     public ResponseEntity<String> salvarArquivo(@RequestParam("file") MultipartFile file) {
 *         log.info("Recebendo o arquivo: ", file.getOriginalFilename());
 *         var caminho = pathArquivos + UUID.randomUUID() + "." + extrairExtensao(file.getOriginalFilename());
 *
 *         log.info("Novo nome do arquivo: " + caminho);
 *
 *         try {
 *             Files.copy(file.getInputStream(), Path.of(caminho), StandardCopyOption.REPLACE_EXISTING);
 *             return new ResponseEntity<>("{ \"mensagem\": \"Arquivo carregado com sucesso!\"}", HttpStatus.OK);
 *         } catch (Exception e) {
 *             log.error("Erro ao processar arquivo", e);
 *             return new ResponseEntity<>("{ \"mensagem\": \"Erro ao carregar o arquivo!\"}", HttpStatus.INTERNAL_SERVER_ERROR);
 *         }
 *     }
 *
 *     private String extrairExtensao(String nomeArquivo) {
 *         int i = nomeArquivo.lastIndexOf(".");
 *         return nomeArquivo.substring(i + 1);
 *     }
 *
 */

}
