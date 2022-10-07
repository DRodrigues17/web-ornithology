package com.br.puc.startdb.webornithology.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passaro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String linkImagem;
    private String nome;
    private String nomeIngles;
    private String nomeLatin;
    private String tamanho;
    private String genero;
    private String corPredominante;
    private String familia;
    private String habitat;


}
