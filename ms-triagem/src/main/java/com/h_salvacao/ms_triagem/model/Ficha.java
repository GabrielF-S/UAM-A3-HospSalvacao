package com.h_salvacao.ms_triagem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ficha implements Serializable {

    private Long id;
    private Token token;
    private String sintomas;
    private  String pressao;
    private Float temperatura;
}
