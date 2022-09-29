package com.br.puc.startdb.webornithology.service;

import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.repository.PassaroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassaroService {

    @Autowired
    private final PassaroRepository repository;

    public List<Passaro> findAll(){
        return  repository.findAll();
    }

    public Optional<Passaro> findById(Long id){
        return  repository.findById(id);
    }

    public Passaro savePassaro( Passaro passaro){
        return  repository.save(passaro);
    }
}
