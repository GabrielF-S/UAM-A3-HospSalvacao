package com.h_salvacao.ms_medico.model;

import com.h_salvacao.ms_medico.util.Medicacao;
import com.h_salvacao.ms_medico.util.Queue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receita implements Serializable {
    private Long id;
    private String numToken;
    private Long fichaId;
    private String nomePaciente;
    private Queue<Medicacao> medicacoes;



}

