package com.h_salvacao.ms_guiche.service;

import com.h_salvacao.ms_guiche.model.Ficha;
import com.h_salvacao.ms_guiche.model.Paciente;
import com.h_salvacao.ms_guiche.model.Token;

public interface GuicheService {

    void adicionarFila(Token token);

    Integer pegarTotal();

    Token chamarProximo();

    Paciente salvarPaciente(Paciente paciente);

    Paciente atualizarPaciente(Paciente paciente);

    Token encaminharToken(Token token);
}
