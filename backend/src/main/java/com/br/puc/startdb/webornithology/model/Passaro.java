package com.br.puc.startdb.webornithology.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private String nome;

    @NotBlank
    private String nomeLatin;

    private String tamanho;

    @NotBlank
    private String genero;

    @NotBlank
    private String corPredominante;

    @NotBlank
    private String familia;

    private String habitat;
    private String local;
    private LocalDate data;
    private LocalTime hora;

    //@todo
    //adição de imagem atrelada aos passaros

}
