package com.h_salvacao.ms_connect.service;

import com.h_salvacao.ms_connect.entity.Ficha;

public interface FichaService {

    Ficha salvarFicha(Ficha ficha);

    Ficha getFicha(Long tokenId);

    Ficha atualizarFicha(Ficha ficha);
}
