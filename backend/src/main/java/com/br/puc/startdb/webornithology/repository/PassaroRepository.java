package com.br.puc.startdb.webornithology.repository;

import com.br.puc.startdb.webornithology.model.Passaro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassaroRepository extends JpaRepository<Passaro, Long> {

    Passaro findByNome(String nome);
    Passaro deleteById(long id);
    Passaro deleteByNome(String nome);
    Passaro findByNomeIngles(String nomeIngles);
    Passaro findByNomeLatin(String nomeLatin);
    Passaro findByFamilia(String familia);

}
