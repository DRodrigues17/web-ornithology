package com.br.puc.startdb.webornithology.service;

import com.br.puc.startdb.webornithology.exception.NaoPermitidoException;
import com.br.puc.startdb.webornithology.exception.ObjetoNaoEncontradoException;
import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.repository.PassaroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PassaroService {

    private final PassaroRepository repository;

    public Collection<Passaro> findAll(int limit) {
        if (repository.findAll().isEmpty()) {
            throw new ObjetoNaoEncontradoException("nenhum passaro, o banco de dados está vazio");
        }
        log.info("Buscando todos os passaros");
        return repository.findAll(PageRequest.of(0, limit)).toList();
    }

    public Passaro findByName(String nome) {
        log.info("Buscando Passaro com o nome: {}", nome);
        return repository.findByNome(nome).orElseThrow(() -> new ObjetoNaoEncontradoException("passaro com o nome" + nome));
    }

    public Passaro create(Passaro passaro) throws RuntimeException {
        if (repository.findAll().contains(passaro)) {
            throw new NaoPermitidoException("já temos um passaro no banco registrado com esse nome");
        }
        log.info("Salvando novo Passaro: {}", passaro.getNome());
        return repository.save(passaro);
    }

    public boolean deleteById(long id) throws RuntimeException {
        if (!repository.existsById(id)) {
            throw new NaoPermitidoException("não existe nenhum passarro com esse id no banco");
        }
        log.info("Deletando Passaro selecionado");
        repository.deleteById(id);
        return true;
    }
}
