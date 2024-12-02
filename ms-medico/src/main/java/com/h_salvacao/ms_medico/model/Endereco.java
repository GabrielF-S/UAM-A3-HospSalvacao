package com.h_salvacao.ms_medico.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    private long id;
    private String lougradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;

}
