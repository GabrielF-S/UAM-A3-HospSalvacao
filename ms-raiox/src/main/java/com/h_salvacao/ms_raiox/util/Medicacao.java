package com.h_salvacao.ms_raiox.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicacao implements Serializable {
    private String nome;
    private String descricao;
    private Long tempoDeUso;
    private String frequencia;

}
