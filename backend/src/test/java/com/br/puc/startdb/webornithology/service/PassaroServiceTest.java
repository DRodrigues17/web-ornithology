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

@ExtendWith(MockitoExtension.class)
class PassaroServiceTest {

    @InjectMocks
    public PassaroService service;
    @Mock
    public PassaroRepository repository;

    @Test
    void deveAcharTodosComSucesso() {
        List<Passaro> resposta = List.of(new Passaro());

        Mockito.when(repository.findAll((Sort) any())).thenReturn(resposta);

        Assertions.assertNotNull(service.findAll(1));
    }

    @Test
    void deveAcharPeloNomeComSucesso() {
        Passaro passaro = new Passaro();
        passaro.setNome("urubu");

        //Mockito.when(repository.findByNome(anyString())).thenReturn(passaro);

        Passaro resposta = service.findByName("urubu");

        Assertions.assertNotNull(resposta);
        Assertions.assertEquals("urubu", resposta.getNome());
    }

    @Test
    void deveDarLancarEnxceptionDeNaoEncontradoPoisPassaroNaoExisteNoBanco() {

    }
}
