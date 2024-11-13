package com.h_salvacao.ms_token.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_ficha")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numToken;

    @JsonFormat(pattern = "dd/MM/yy HH:mm")
    private LocalDateTime dataEntrada;

    @ManyToOne
    @JoinColumn(name = "paciente.id")
    private Paciente paciente;

    private AtendimentoStatus status;

    private TipoAtendimento atendimento;

    @PrePersist
    public void prePersist() {
        setDataEntrada(LocalDateTime.now());

    }

    @Override
    public String toString() {
        return "Hospital Salvação\n" +
                "Data ='" + dataEntrada + '\'' +
                "-----------------------" +
                ", Ficha =" + numToken +
                ", paciente=" + paciente.getNome() +
                ", atendimento=" + atendimento +
                "-----------------------";
    }
}
