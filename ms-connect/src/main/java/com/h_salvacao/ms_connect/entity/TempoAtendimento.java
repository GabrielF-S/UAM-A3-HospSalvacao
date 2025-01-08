package com.h_salvacao.ms_connect.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_tempo_atendimento")
public class TempoAtendimento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String numToken;

    @JsonFormat(pattern = "dd/MM/yy HH:mm")
    private LocalDateTime dataEntrada;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horarioEntrada;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horarioSaida;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime entradaTriagem;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime saidaTriagem;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime entradaGuiche;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime saidaGuiche;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime entradaDoutor;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime saidaDoutor;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime entradaMedicacao;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime saidaMedicacao;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime entradaRaioX;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime saidaRaioX;

    public TempoAtendimento(String numToken, LocalDateTime dataEntrada, LocalTime time) {
        this.numToken = numToken;
        this.dataEntrada = dataEntrada;
        this.horarioEntrada = time;
    }
}
