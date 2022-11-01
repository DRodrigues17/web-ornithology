package com.br.puc.startdb.webornithology.service;

import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.repository.PassaroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Collection<Passaro> findAll(int limit){
        log.info("Buscando todos os passaros");
        return  repository.findAll(PageRequest.of(0, limit)).toList();
    }

    public Passaro findByName(String name){
        log.info("Buscando Passaro com o nome: {}", name);
        return  repository.findByNome(name);
    }

    public Passaro create(Passaro passaro) {
        log.info("Salvando novo Passaro: {}", passaro.getNome());
        return repository.save(passaro);
    }
    public boolean deleteById(long id){
        log.info("Deletando Passaro selecionado");
        repository.deleteById(id);
        return true;
    }
}
