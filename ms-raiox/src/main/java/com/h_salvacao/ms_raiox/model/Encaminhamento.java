package com.h_salvacao.ms_raiox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encaminhamento implements Serializable {
    private Long id;
    private String numToken;
    private Long fichaId;
    private  String nomePaciente;
    private List<String> regioesRaiox;
    private List<MedicacaoIntravenosa> listaMedicacoes;
}
