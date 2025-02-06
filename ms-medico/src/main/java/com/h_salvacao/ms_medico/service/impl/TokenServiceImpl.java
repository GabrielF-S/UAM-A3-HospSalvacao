package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.feignCliente.TokenFeignClient;
import com.h_salvacao.ms_medico.model.*;
import com.h_salvacao.ms_medico.service.*;
import com.h_salvacao.ms_medico.util.AtendimentoStatus;
import com.h_salvacao.ms_medico.util.Queue;
import com.h_salvacao.ms_medico.util.TipoAtendimento;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Service
public class TokenServiceImpl implements TokenService {


    Queue<Token> listaAtendimento = new Queue<>();

    Queue<Token> listaRetorno = new Queue<>();;

    @Autowired
    TempoAtendimentoService atendimentoService;

    private  final TokenProducerSender tokenProducerSender;
    private final TokenFeignClient tokenFeignClient;

    @Override
    public void adicionarFila(Token value) {
        listaAtendimento.enqueue(value);
    }

    @Override
    public Integer getTotal() {
        return listaRetorno.size() + listaAtendimento.size();
    }

    @Override
    public Token chamarProximo() {
        Token proximo = getProximo();
        if (proximo.getStatus() == AtendimentoStatus.DOUTOR) {
            TempoAtendimento tempoAtendimento = atendimentoService.getTempoAtendimento(proximo.getNumToken());
            if(tempoAtendimento.getEntradaDoutor() == null){
                atendimentoService.atualizarEntradaMedico(tempoAtendimento);
            }else {
                atendimentoService.atualizarEntradaRetorno(tempoAtendimento);
            }
            tokenProducerSender.sendoToAtendimento(proximo);
            return proximo;
        }
        return proximo;
    }

    private Token getProximo() {
        if (getTotal() > 0) {
            String numToken = verificarFilas().getNumToken();
            Token token = tokenFeignClient.getToken(numToken).getBody();
            if (token != null && token.getStatus() == AtendimentoStatus.DOUTOR) {
                return token;
            }
        } else
            throw new RuntimeException("Fila vazia");
        return getProximo();
    }

    private Token verificarFilas() {
        Token tokenComun, tokenRetorno;
        if (listaAtendimento.checkFirst() != null && listaRetorno.checkFirst() == null) {
            return listaAtendimento.dequeue();
        }
        if (listaAtendimento.checkFirst() == null && listaRetorno.checkFirst() != null) {
            return listaRetorno.dequeue();
        }
        tokenComun = listaAtendimento.checkFirst();
        tokenRetorno = listaRetorno.checkFirst();
        return getComumOuRetorno(tokenComun, tokenRetorno);

    }

    private Token getComumOuRetorno(Token tokenComun, Token tokenRetorno) {
        LocalTime comumTime, retornoTime;
        comumTime = atendimentoService.getTempoAtendimento(tokenComun.getNumToken()).getSaidaGuiche();
        retornoTime = atendimentoService.getRetorno(tokenRetorno.getNumToken());


        if (tokenComun.getAtendimento() == tokenRetorno.getAtendimento()) {
            if (comumTime.isBefore(retornoTime)) {
                return listaAtendimento.dequeue();
            } else {
                return listaRetorno.dequeue();
            }
        } else {
            //Verifica se um dos dois é Urgente
            if (tokenComun.getAtendimento() == TipoAtendimento.URGENTE) {
                return listaAtendimento.dequeue();
            }
            if (tokenRetorno.getAtendimento() == TipoAtendimento.URGENTE) {
                return listaRetorno.dequeue();
            }
            if (tokenComun.getAtendimento() == TipoAtendimento.COMUM) {
                if (comumTime.until(retornoTime, ChronoUnit.MINUTES) > 30) {
                    return listaAtendimento.dequeue();
                } else {
                    return listaRetorno.dequeue();
                }
            }
            if (tokenRetorno.getAtendimento() == TipoAtendimento.COMUM) {
                if (retornoTime.until(comumTime, ChronoUnit.MINUTES) > 30) {
                    return listaRetorno.dequeue();
                } else {
                    return listaAtendimento.dequeue();
                }
            }
        }
        throw new RuntimeException("Erro ao chamar proximo da fila");
    }

    public Token setStatus(Token token, AtendimentoStatus atendimentoStatus) {
        token.setStatus(atendimentoStatus);
        return token;
    }

    @Override
    public Token getToken(String numToken) {
        return tokenFeignClient.getToken(numToken).getBody();
    }

    @Override
    public void updateToken(Token token) {
        tokenFeignClient.updateToken(token);

    }

    @Override
    public void adicionarFilaRetornoDoRaioX(Token value) { listaRetorno.enqueue(value);
    }

    @Override
    public Token encerrarAtendimento(Token token) {
        token = setStatus(token, AtendimentoStatus.ENCERRADO);
        tokenFeignClient.updateToken(token);
        TempoAtendimento atendimento = atendimentoService.getTempoAtendimento(token.getNumToken());
        atendimentoService.encerrarAtendimento(atendimento);
        return token;
    }

}
