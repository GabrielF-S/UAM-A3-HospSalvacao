package com.h_salvacao.ms_token.service;

import com.h_salvacao.ms_token.entity.Ficha;
import com.h_salvacao.ms_token.entity.FichaAtendimento;
import com.h_salvacao.ms_token.entity.TipoAtendimento;

public interface FichaService {

    Ficha abrirFicha( String cpf, TipoAtendimento tipoAtendimento);

    Ficha abrirFichaSemCadastro(TipoAtendimento atendimento);


    void salvarFicha(Ficha ficha);
}
