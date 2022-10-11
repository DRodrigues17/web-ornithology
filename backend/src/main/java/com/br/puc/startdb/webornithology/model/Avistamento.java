package com.br.puc.startdb.webornithology.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Avistamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String local;
    private LocalDate data;
    private LocalTime hora;
}
