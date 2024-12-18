package com.h_salvacao.ms_connect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicacao implements Serializable {
    private Long id;
    private String nome;
    private Long tempoDeUso;
    private String frequencia;

}
