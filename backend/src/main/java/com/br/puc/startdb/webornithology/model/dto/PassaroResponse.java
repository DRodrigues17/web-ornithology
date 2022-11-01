package com.br.puc.startdb.webornithology.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassaroResponse {

    private long id;
    private String linkImagem;
    private String nome;
    private String nomeIngles;
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
