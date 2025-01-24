package com.h_salvacao.ms_raiox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regiao  implements Serializable {
    private String nome;
    private boolean check;
    private String diagnostico;
}
