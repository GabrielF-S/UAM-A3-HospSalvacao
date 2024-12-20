package com.h_salvacao.ms_raiox.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd/MM/yy")
    private LocalDate dataNascimento;
    private Double peso;
    private Double altura;
    private Endereco endereco;
    private Queue<Medicacao> medicacoes;


}
