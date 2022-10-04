package com.br.puc.startdb.webornithology.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passaro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@todo
    //adição de imagem atrelada aos passaros
    private String imageUrl;
    private String nome;
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
