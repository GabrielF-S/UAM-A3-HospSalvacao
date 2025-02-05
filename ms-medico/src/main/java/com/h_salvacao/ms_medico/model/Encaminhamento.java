package com.h_salvacao.ms_medico.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.h_salvacao.ms_medico.util.Regiao;
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
    private List<Regiao> regioesRaiox;
    @JsonProperty(value = "medicacaoIntravenosa")
    private List<MedicacaoIntravenosa> listaMedicacoes;
}
