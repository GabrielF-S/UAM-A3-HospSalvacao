package com.h_salvacao.ms_triagem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

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


}
