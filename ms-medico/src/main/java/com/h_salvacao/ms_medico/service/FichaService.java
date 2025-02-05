package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_medico.model.Ficha;

public interface FichaService {
    Ficha getFicha(Long tokenId);

    Ficha atulizarFicha(Ficha ficha);
}
