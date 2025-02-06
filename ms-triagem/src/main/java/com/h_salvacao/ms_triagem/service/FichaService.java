package com.h_salvacao.ms_triagem.service;

import com.h_salvacao.ms_triagem.model.Ficha;

public interface FichaService {

    Ficha enviarFicha(Ficha ficha);

    Ficha atualizarToken(Ficha ficha);
}
