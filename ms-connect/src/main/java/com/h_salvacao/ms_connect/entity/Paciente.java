package com.h_salvacao.ms_connect.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_paciente")
public class Paciente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yy")
    private LocalDate dataNascimento;
    private Double peso;
    private Double altura;
}
