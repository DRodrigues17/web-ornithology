package com.br.puc.startdb.webornithology.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassaroRequest {

    @NotNull
    private String codigoImagem;

    @NotBlank(message = "informação necessária")
    private String nome;
    @NotBlank(message = "informação necessária")
    private String nomeLatin;
    @NotBlank(message = "informação necessária")
    private String tamanho;
    @NotBlank(message = "informação necessária")
    private String genero;
    @NotBlank(message = "informação necessária")
    private String corPredominante;
    @NotBlank(message = "informação necessária")
    private String familia;
    @NotBlank(message = "informação necessária")
    private String habitat;
    @NotBlank(message = "informação necessária")
    private String local;

    @PastOrPresent(message = "data inválida")
    private LocalDate data;
    @PastOrPresent(message = "hora inválida")
    private LocalTime hora;

}
