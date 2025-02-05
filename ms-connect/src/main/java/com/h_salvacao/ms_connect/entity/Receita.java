package com.h_salvacao.ms_connect.entity;

import com.h_salvacao.ms_connect.util.Medicacao;
import com.h_salvacao.ms_connect.util.Queue;
import com.h_salvacao.ms_connect.util.QueueConverter;
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

