package com.h_salvacao.ms_triagem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Token implements Serializable {

    private Long id;
    private String numToken;

    @JsonFormat(pattern = "dd/MM/yy HH:mm")
    private LocalDateTime dataEntrada;


    private Paciente paciente;

    private AtendimentoStatus status;

    private TipoAtendimento atendimento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(id, token.id) && Objects.equals(numToken, token.numToken);
    }

    @Override
    public String toString() {
        return "Hospital Salvação\n" +
                "Data: " + dataEntrada + '\n' +
                "-----------------------" + '\n' +
                "Ficha: " + numToken + '\n' +
                "paciente: " + (paciente != null ? paciente.getNome() : "N/A") + '\n' +
                "atendimento: " + atendimento + '\n' +
                "-----------------------"+ '\n' ;
    }

}
