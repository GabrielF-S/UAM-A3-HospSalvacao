package com.h_salvacao.ms_medico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicacao {
    private String nome;
    private String descricao;
    private Long tempoDeUso;
    private String frequencia;
    private Token token;
}
