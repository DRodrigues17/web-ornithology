package com.br.puc.startdb.webornithology.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passaro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomePortugues;
    private String nomeLatin;
    private String tamanho;
    private String genero;
    private String corPredominante;
    private String familia;
    private String habitat;
    private String local;
    private LocalDate data;
    private LocalTime hora;


}
