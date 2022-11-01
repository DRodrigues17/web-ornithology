package com.br.puc.startdb.webornithology.converter.impl;

import com.br.puc.startdb.webornithology.converter.PassaroConverter;
import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.model.dto.PassaroRequest;
import com.br.puc.startdb.webornithology.model.dto.PassaroResponse;
import org.springframework.stereotype.Component;

@Component
public class PassaroConverterImpl implements PassaroConverter<Passaro, PassaroResponse, PassaroRequest> {

    @Override
    public PassaroResponse convert(Passaro passaro) {
        return PassaroResponse.builder()
                .id(passaro.getId())
                .linkImagem(passaro.getLinkImagem())
                .nome(passaro.getNome())
                .nomeIngles(passaro.getNomeIngles())
                .nomeLatin(passaro.getNomeLatin())
                .tamanho(passaro.getTamanho())
                .genero(passaro.getGenero())
                .corPredominante(passaro.getCorPredominante())
                .familia(passaro.getFamilia())
                .habitat(passaro.getHabitat()).build();
    }

    @Override
    public Passaro convert(PassaroRequest passaro) {
        return Passaro.builder()
                .linkImagem(passaro.getLinkImagem())
                .nome(passaro.getNome())
                .nomeIngles(passaro.getNomeIngles())
                .nomeLatin(passaro.getNomeLatin())
                .tamanho(passaro.getTamanho())
                .genero(passaro.getGenero())
                .corPredominante(passaro.getCorPredominante())
                .familia(passaro.getFamilia())
                .habitat(passaro.getHabitat()).build();
    }
}
