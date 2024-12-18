package com.h_salvacao.ms_connect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_receitas")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numToken;
    private Long fichaId;
    private String nomePaciente;
    @Convert(converter = QueueConverter.class)
    private Queue<Medicacao> medicacoes;



}

