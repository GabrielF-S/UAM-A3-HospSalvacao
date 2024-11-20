package com.h_salvacao.ms_triagem.model;

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
public class Paciente  implements Serializable {

    public  Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Double peso;
    private Double altura;
}
