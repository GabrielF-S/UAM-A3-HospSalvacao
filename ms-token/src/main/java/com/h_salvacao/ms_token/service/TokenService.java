package com.h_salvacao.ms_token.service;

import com.h_salvacao.ms_token.model.Token;
import com.h_salvacao.ms_token.model.TipoAtendimento;

public interface TokenService {

    Token abrirFicha(String cpf, TipoAtendimento tipoAtendimento);

    Token abrirFichaSemCadastro(TipoAtendimento atendimento);


    Token salvarToken(Token token);
}
