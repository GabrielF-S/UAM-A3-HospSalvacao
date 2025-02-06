package com.h_salvacao.ms_raiox.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.h_salvacao.ms_raiox.util.Regiao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encaminhamento implements Serializable {
    private Long id;
    private String numToken;
    private Long fichaId;
    private String nomePaciente;
    private List<Regiao> regioesRaiox;
    @JsonProperty(value = "medicacaoIntravenosa")
    private List<MedicacaoIntravenosa> listaMedicacoes;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Encaminhamento that = (Encaminhamento) o;
        return Objects.equals(id, that.id) && Objects.equals(numToken, that.numToken) && Objects.equals(fichaId, that.fichaId) && Objects.equals(nomePaciente, that.nomePaciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numToken, fichaId, nomePaciente);
    }

}
