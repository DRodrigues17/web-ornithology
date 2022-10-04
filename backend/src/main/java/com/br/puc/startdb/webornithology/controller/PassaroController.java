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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Base64;
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
    public ResponseEntity<Response> savePassaro(@RequestBody @Valid PassaroRequest passaro, String localImagem) throws Exception {
        passaro.setCodigoImagem(encodeImage(localImagem));
        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now()).data(Map.of("passaro",
                                service.create(converter.convert(passaro))))
                        .message("Passaro criado")
                        .status(CREATED).statusCode(CREATED.value()).build()
        );
    }

    private static String encodeImage(String imgPath) throws  Exception{
        FileInputStream imageStream = new FileInputStream(imgPath);
        byte[] data = imageStream.readAllBytes();
        String imagemCodificada = Base64.getEncoder().encodeToString(data);

        imageStream.close();
        return imagemCodificada;
    }

    public static void decodeImage(String txtPath, String savePath) throws  Exception{
        FileInputStream inputStream = new FileInputStream(txtPath);
        byte[] data = Base64.getDecoder().decode(new String(inputStream.readAllBytes()));

        FileOutputStream output = new FileOutputStream(savePath);
        output.write(data);
        output.close();
        inputStream.close();

    }
}
