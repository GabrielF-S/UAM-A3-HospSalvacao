package com.h_salvacao.ms_connect.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_encaminhamento")
public class Encaminhamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numToken;
    private Long fichaId;
    private  String nomePaciente;
    private List<Regiao> regioesRaiox;
    private List<MedicacaoIntravenosa> listaMedicacoes;
}
