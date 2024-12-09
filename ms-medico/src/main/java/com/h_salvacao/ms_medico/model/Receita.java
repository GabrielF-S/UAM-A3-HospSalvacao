package com.h_salvacao.ms_medico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receita {
    private Long id;
    private Token token;
    private Ficha ficha;
    private Queue<Medicacao> medicacoes;



}

