package com.br.puc.startdb.webornithology.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassaroRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String nomeLatin;
    @NotBlank
    private String tamanho;
    @NotBlank
    private String genero;
    @NotBlank
    private String corPredominante;
    @NotBlank
    private String familia;
    @NotBlank
    private String habitat;
    @NotBlank
    private String local;
    private LocalDate data;
    private LocalTime hora;
}
