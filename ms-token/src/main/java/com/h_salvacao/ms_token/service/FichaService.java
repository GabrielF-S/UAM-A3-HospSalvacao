package com.h_salvacao.ms_token.service;

import com.h_salvacao.ms_token.entity.Token;
import com.h_salvacao.ms_token.entity.TipoAtendimento;

public interface FichaService {

    Token abrirFicha(String cpf, TipoAtendimento tipoAtendimento);

    Token abrirFichaSemCadastro(TipoAtendimento atendimento);


    void salvarFicha(Token token);
}
