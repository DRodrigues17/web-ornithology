package com.br.puc.startdb.webornithology.converter;

import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.model.dto.PassaroRequest;
import com.br.puc.startdb.webornithology.model.dto.PassaroResponse;
import org.springframework.stereotype.Component;

@Component
public interface PassaroConverter <T extends Passaro, O extends PassaroResponse, I extends PassaroRequest>{

    O convert(T passaro);

    T convert(I passaro);
}
