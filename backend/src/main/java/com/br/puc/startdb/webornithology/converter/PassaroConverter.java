package com.br.puc.startdb.webornithology.converter;

import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.model.dto.PassaroRequest;
import com.br.puc.startdb.webornithology.model.dto.PassaroResponse;
import org.springframework.stereotype.Component;

@Component
public interface PassaroConverter <M extends Passaro, R extends PassaroResponse, Request extends PassaroRequest>{

    R convert(M passaro);

    M convert(Request passaro);
}
