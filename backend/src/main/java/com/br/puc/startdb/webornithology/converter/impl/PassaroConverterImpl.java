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
                .nomeIngles(passaro.getNomeIngles().toLowerCase())
                .nomeLatin(passaro.getNomeLatin().toLowerCase())
                .tamanho(passaro.getTamanho().toLowerCase())
                .genero(passaro.getGenero().toLowerCase())
                .corPredominante(passaro.getCorPredominante().toLowerCase())
                .familia(passaro.getFamilia().toLowerCase())
                .habitat(passaro.getHabitat().toLowerCase()).build();
    }

    @Override
    public Passaro convert(PassaroRequest passaro) {
        return Passaro.builder()
                .linkImagem(passaro.getLinkImagem())
                .nome(passaro.getNome())
                .nomeIngles(passaro.getNomeIngles().toLowerCase())
                .nomeLatin(passaro.getNomeLatin().toLowerCase())
                .tamanho(passaro.getTamanho().toLowerCase())
                .genero(passaro.getGenero().toLowerCase())
                .corPredominante(passaro.getCorPredominante().toLowerCase())
                .familia(passaro.getFamilia().toLowerCase())
                .habitat(passaro.getHabitat().toLowerCase()).build();
    }
}
