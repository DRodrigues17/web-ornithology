package com.br.puc.startdb.webornithology.repository;

import com.br.puc.startdb.webornithology.model.Passaro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassaroRepository extends JpaRepository<Passaro, Long> {

}
