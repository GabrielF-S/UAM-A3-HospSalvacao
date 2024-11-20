package com.h_salvacao.ms_token.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenAtendimento {
    private String cpf;
    private TipoAtendimento tipoAtendimento;
}