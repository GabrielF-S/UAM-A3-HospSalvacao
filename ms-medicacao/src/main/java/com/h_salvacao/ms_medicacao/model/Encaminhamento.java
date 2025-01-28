package com.h_salvacao.ms_medicacao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encaminhamento {

    private Long id;
    private String numToken;
    private Long fichaId;
    private String nomePaciente;
    private List<Regiao> regioesRaiox;
    private List<MedicacaoIntravenosa> listaMedicacoes;

}
