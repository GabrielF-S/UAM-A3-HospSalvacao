package com.h_salvacao.ms_triagem.service.impl;

import com.h_salvacao.ms_triagem.feignCliente.FichaFeingClient;
import com.h_salvacao.ms_triagem.model.Ficha;
import com.h_salvacao.ms_triagem.model.TempoAtendimento;
import com.h_salvacao.ms_triagem.model.Token;
import com.h_salvacao.ms_triagem.service.FichaService;
import com.h_salvacao.ms_triagem.service.TempoAtendimentoService;
import com.h_salvacao.ms_triagem.service.TokenService;
import com.h_salvacao.ms_triagem.util.AtendimentoStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FichaServiceImpl implements FichaService {
    private final FichaFeingClient fichaFeingClient;
    @Autowired
    TempoAtendimentoService tempoAtendimentoService;
    @Autowired
    TokenService tokenService;

    @Override
    public Ficha enviarFicha(Ficha ficha) {
        ficha = fichaFeingClient.saveFicha(ficha);
        ficha = atualizarToken(ficha);
        TempoAtendimento tempoAtendimento = tempoAtendimentoService.getTempoAtendimento(ficha.getToken().getNumToken());
        tempoAtendimentoService.atualizarSaidaAtendimento(tempoAtendimento);
        tokenService.sendToken(ficha.getToken());
        return ficha;
    }

    @Override
    public Ficha atualizarToken(Ficha ficha) {
        Token token = tokenService.setStatus(ficha.getToken(), AtendimentoStatus.GUICHE);
        tokenService.updateToken(token);
        return ficha;
    }
}
