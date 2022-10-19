package com.br.puc.startdb.webornithology.service;

import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.repository.PassaroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class PassaroServiceTest {

    @InjectMocks
    public PassaroService passaroService;

    @Mock
    public PassaroRepository passaroRepository;

    @Test
    void findAllTest() {
        List<Passaro> resposta = List.of(new Passaro());

        Mockito.when(passaroRepository.findAll((Sort) any())).thenReturn(resposta);

        Assertions.assertNotNull(passaroService.findAll(1));
    }

    @Test
    void findByNameTest() {
        Passaro passaro = new Passaro();
        passaro.setNome("arroz");

        Mockito.when(passaroRepository.findByNome(anyString())).thenReturn(passaro);

        Passaro resposta = passaroService.findByName("arroz");

        Assertions.assertNotNull(resposta);
        Assertions.assertEquals("arroz", resposta.getNome());
    }
}
