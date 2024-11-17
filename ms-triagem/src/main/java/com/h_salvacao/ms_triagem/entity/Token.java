package com.h_salvacao.ms_triagem.entity;

import java.time.LocalDateTime;

public class Token {

    private Long id;
    private String numToken;

    private LocalDateTime dataEntrada;

    private Paciente paciente;

    private AtendimentoStatus status;

    private TipoAtendimento atendimento;

}
