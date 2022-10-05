package com.br.puc.startdb.webornithology.converter.impl;

import com.br.puc.startdb.webornithology.converter.PassaroConverter;
import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.model.dto.PassaroRequest;
import com.br.puc.startdb.webornithology.model.dto.PassaroResponse;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.Base64;

@Component
public class PassaroConverterImpl implements PassaroConverter<Passaro, PassaroResponse, PassaroRequest> {

    @Override
    public PassaroResponse convert(Passaro passaro) {
        return PassaroResponse.builder()
                .imagemPassaro(decodeImage(passaro.getCodigoImagem()))
                .nome(passaro.getNome())
                .nomeLatin(passaro.getNomeLatin())
                .tamanho(passaro.getTamanho())
                .genero(passaro.getGenero())
                .corPredominante(passaro.getCorPredominante())
                .familia(passaro.getFamilia())
                .habitat(passaro.getHabitat())
                .local(passaro.getLocal())
                .data(passaro.getData())
                .hora(passaro.getHora()).build();
    }

    @Override
    public Passaro convert(PassaroRequest passaro) {
        return Passaro.builder()
                .codigoImagem(passaro.getCodigoImagem())
                .nome(passaro.getNome())
                .nomeLatin(passaro.getNomeLatin())
                .tamanho(passaro.getTamanho())
                .genero(passaro.getGenero())
                .corPredominante(passaro.getCorPredominante())
                .familia(passaro.getFamilia())
                .habitat(passaro.getHabitat())
                .local(passaro.getLocal())
                .data(passaro.getData())
                .hora(passaro.getHora()).build();
    }

    public static File decodeImage(String imagemCodificada) throws  Exception{

        FileInputStream inputStream = new FileInputStream(imagemCodificada);
        byte[] data = Base64.getDecoder().decode(new String(inputStream.readAllBytes()));

        FileOutputStream output = new FileOutputStream(savePath);
        output.write(data);
        output.close();
        inputStream.close();
    }
}
