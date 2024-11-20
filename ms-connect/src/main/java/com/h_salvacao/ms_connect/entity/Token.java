package com.h_salvacao.ms_connect.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity
@Table(name = "tb_token")
public class Token implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numToken;
    @Column(name = "data_entrada")
    @JsonFormat(pattern = "dd/MM/yy HH:mm")
    private LocalDateTime dataEntrada;

    @ManyToOne
    @JoinColumn(name = "paciente.id")
    private Paciente paciente;

    private  AtendimentoStatus status;

    private TipoAtendimento atendimento;

    @PrePersist
    public void prePersist(){
        setDataEntrada(LocalDateTime.now());
    }


    @Override public String toString() {
        return "Hospital Salvação\n" +
                "Data ='" + dataEntrada +
                '\'' + "-----------------------" +
                ", Ficha =" + numToken +
                ", paciente=" + (paciente != null ? paciente.getNome() : "N/A") +
                ", atendimento=" + atendimento +
                "-----------------------";
    }

}
