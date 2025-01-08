package com.h_salvacao.ms_triagem.service.impl;

import com.h_salvacao.ms_triagem.feignCliente.TriagemFeignClient;
import com.h_salvacao.ms_triagem.model.*;
import com.h_salvacao.ms_triagem.service.TriagemProducerSender;
import com.h_salvacao.ms_triagem.service.TriagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Service
public class TriagemServiceImpl implements TriagemService {
    @Autowired
    Triagem triagem;

    private final TriagemProducerSender triagemProducerSender;

    private final TriagemFeignClient feignClient;




    @Override
    public void adcionarFila(Token token) {

        switch (token.getAtendimento()) {
            case COMUM -> {
                triagem.adicionarFilaComum(token);

                break;
            }
            case PREFERENCIAL -> {
                triagem.adicionarFilaPreferencial(token);

                break;
            }
            case URGENTE -> {
                triagem.adicionarFilaUrgente(token);

                break;
            }
        }
    }

    @Override
    public Queue<Token> exibirFila() {
        return triagem.getFilaComum();
    }

    @Override
    public Integer pegarTotal() {
        return triagem.getFilaComum().size() + triagem.getFilaPreferencial().size() + triagem.getFilaUrgente().size();
    }

    @Override
    public Token chamarProximo() {
        Token proximo = getProximo();
        triagemProducerSender.sendoToAtendimento(proximo);
        return proximo;

    }

    @Override
    public Ficha enviarFicha(Ficha ficha) {
        ficha = feignClient.sendFicha(ficha);
        ficha =  atualizarToken(ficha);
        triagemProducerSender.sendFicha(ficha.getToken());
        return ficha;
    }

    @Override
    public Ficha atualizarToken(Ficha ficha) {
        Token token = ficha.getToken();
        token.setStatus(AtendimentoStatus.GUICHE);
        feignClient.updateToken(token);
        ficha.setToken(token);
        return ficha;
    }


    private Token getProximo() {

        if (pegarTotal() > 0) {
            String numToken = verificarFilas().getNumToken();
            Token token = feignClient.getToken(numToken).getBody();

            if (token != null && token.getStatus() == AtendimentoStatus.TRIAGEM) {
                return token;
            } else {
                return getProximo();
            }
        }

        return new Token(0L,"0", LocalDateTime.now(), null, AtendimentoStatus.DESCONHECIDO, TipoAtendimento.DESCONHECIDO);

    }

    private Token verificarFilas() {
        Token tokenComum, tokenPreferencial;

        if (triagem.getFilaUrgente().checkFirst() != null) {
            return triagem.getFilaUrgente().dequeue();
        }
        if (triagem.getFilaPreferencial().checkFirst() == null && triagem.getFilaComum().checkFirst() != null) {
            return triagem.getFilaComum().dequeue();
        }
        if(triagem.getFilaPreferencial().checkFirst() != null && triagem.getFilaComum().checkFirst() ==null){
            return triagem.getFilaPreferencial().dequeue();
        }
        if (triagem.getFilaComum().checkFirst() != null && triagem.getFilaPreferencial().checkFirst() != null) {
            tokenComum = triagem.getFilaComum().checkFirst();
            tokenPreferencial = triagem.getFilaPreferencial().checkFirst();
            return getComumOuPreferencial(tokenComum, tokenPreferencial);
        }
        return triagem.getFilaComum().dequeue();

    }

    private Token getComumOuPreferencial(Token tokenComum, Token tokenPreferencial) {
        if (tokenComum.getDataEntrada().isBefore(tokenPreferencial.getDataEntrada())) {
            if (tokenComum.getDataEntrada().until(tokenPreferencial.getDataEntrada(), ChronoUnit.MINUTES) > 40) {
                return triagem.getFilaComum().dequeue();
            }
        }
        return triagem.getFilaPreferencial().dequeue();
    }


}
