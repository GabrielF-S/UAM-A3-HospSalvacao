package com.h_salvacao.ms_medicacao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.h_salvacao.ms_medicacao.util.Medicacao;
import com.h_salvacao.ms_medicacao.util.Queue;
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
