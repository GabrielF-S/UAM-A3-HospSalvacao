package com.h_salvacao.ms_medicacao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.h_salvacao.ms_medicacao.util.AtendimentoStatus;
import com.h_salvacao.ms_medicacao.util.TipoAtendimento;
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
    private boolean retorno;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(id, token.id) && Objects.equals(numToken, token.numToken);
    }


}
