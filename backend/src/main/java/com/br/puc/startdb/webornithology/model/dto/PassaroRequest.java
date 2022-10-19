package com.br.puc.startdb.webornithology.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassaroRequest {

    @NotNull
    private String linkImagem;

    @NotBlank(message = "informação necessária")
    private String nome;
    @NotBlank(message = "informação necessária")
    private String nomeIngles;
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


}
