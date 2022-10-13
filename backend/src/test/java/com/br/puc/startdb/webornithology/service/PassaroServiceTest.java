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
public class PassaroServiceTest {

    // Classe que vai ser testada
    @InjectMocks
    public PassaroService passaroService;

    // Classe que chama o banco e que vai ser simulada
    @Mock
    public PassaroRepository passaroRepository;

    @Test
    public void findAllTest() {
        // Definições de respostas
        List<Passaro> resposta = List.of(new Passaro());

        // Simular as chamadas do banco
        Mockito.when(passaroRepository.findAll((Sort) any())).thenReturn(resposta);

        // Chamar a classe
        Assertions.assertNotNull(passaroService.findAll(1));
    }

    @Test
    public void findByNameTest() {
        // Definição de resposta
        Passaro passaro = new Passaro();
        passaro.setNome("arroz");

        // Simular as chamadas do banco
        Mockito.when(passaroRepository.findByNome(anyString())).thenReturn(passaro);

        // Chamando a classe
        Passaro resposta = passaroService.findByName("arroz");

        // Testando resposta
        Assertions.assertNotNull(resposta);
        Assertions.assertEquals("arroz", resposta.getNome());
    }
}