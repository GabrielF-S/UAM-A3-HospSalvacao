package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.feignCliente.MedicoFeignClient;
import com.h_salvacao.ms_medico.model.*;
import com.h_salvacao.ms_medico.service.ImprimirReceitaService;
import com.h_salvacao.ms_medico.service.MedicoProducerSender;
import com.h_salvacao.ms_medico.service.MedicoService;
import com.h_salvacao.ms_medico.service.TempoAtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    Triagem triagem;

    @Autowired
    ImprimirReceitaService receitaService;
    @Autowired
    TempoAtendimentoService atendimentoService;

    private final MedicoProducerSender producerSender;


    private final MedicoFeignClient feignClient;

    @Override
    public void adicionarFila(Token value) {

        triagem.adicionarFila(value);

    }

    @Override
    public Integer getTotal() {
        return triagem.getValorTotal();
    }

    @Override
    public Token chamarProximo() {
        Token proximo = getProximo();

        if (proximo.getStatus() == AtendimentoStatus.DOUTOR) {
            TempoAtendimento tempoAtendimento = feignClient.getTempoAtendimento(proximo.getNumToken());
            if(tempoAtendimento.getEntradaDoutor() == null){

                atendimentoService.atualizarEntradaMedico(tempoAtendimento);
            }else {
                atendimentoService.atualizarEntradaRetorno(tempoAtendimento);
            }
            producerSender.sendoToAtendimento(proximo);
            return proximo;
        }

        return proximo;

    }

    private Token getProximo() {
        if (getTotal() > 0) {
            String numToken = verificarFilas().getNumToken();
            Token token = feignClient.getToken(numToken).getBody();
            if (token != null && token.getStatus() == AtendimentoStatus.DOUTOR) {
                return token;
            }
        } else
            throw new RuntimeException("Fila vazia");
        return getProximo();
    }

    private Token verificarFilas() {
        Token tokenComun, tokenRetorno;
        if (triagem.getFila().checkFirst() != null && triagem.getFilaRetorno().checkFirst() == null) {
            return triagem.getFila().dequeue();
        }
        if (triagem.getFila().checkFirst() == null && triagem.getFilaRetorno().checkFirst() != null) {
            return triagem.getFilaRetorno().dequeue();
        }

        tokenComun = triagem.getFila().checkFirst();
        tokenRetorno = triagem.getFilaRetorno().checkFirst();
        return getComumOuRetorno(tokenComun, tokenRetorno);

    }

    private Token getComumOuRetorno(Token tokenComun, Token tokenRetorno) {
        LocalTime comumTime, retornoTime;

        comumTime = feignClient.getTempoAtendimento(tokenComun.getNumToken()).getSaidaGuiche();

        retornoTime = getRetornoTime(tokenRetorno.getNumToken());


        if (tokenComun.getAtendimento() == tokenRetorno.getAtendimento()) {
            if (comumTime.isBefore(retornoTime)) {
                return tokenComun;
            } else {
                return tokenRetorno;
            }
        } else {
            //Verifica se um dos dois é Urgente
            if (tokenComun.getAtendimento() == TipoAtendimento.URGENTE) {
                return tokenComun;
            }
            if (tokenRetorno.getAtendimento() == TipoAtendimento.URGENTE) {
                return tokenRetorno;
            }
            if (tokenComun.getAtendimento() == TipoAtendimento.COMUM) {
                if (comumTime.until(retornoTime, ChronoUnit.MINUTES) > 30) {
                    return tokenComun;
                } else {
                    return tokenRetorno;
                }

            }
            if (tokenRetorno.getAtendimento() == TipoAtendimento.COMUM) {
                if (retornoTime.until(comumTime, ChronoUnit.MINUTES) > 30) {
                    return tokenRetorno;
                } else {
                    return tokenComun;
                }

            }


        }
        throw new RuntimeException("Erro ao chamar proximo da fila");
    }


    private LocalTime getRetornoTime(String numToken) {
        TempoAtendimento tempoAtendimento = feignClient.getTempoAtendimento(numToken);
        return (tempoAtendimento.getSaidaRaioX() != null) ? tempoAtendimento.getSaidaRaioX() : tempoAtendimento.getSaidaMedicacao();
    }


    @Override
    public Ficha getFicha(Long tokenId) {
        return feignClient.getFicha(tokenId);
    }

    @Override
    public Ficha atualizarFicha(Ficha ficha) {
        return feignClient.atulizarFicha(ficha);
    }

    @Override
    public Receita salvarReceita(Receita receita) {
        Receita receitaSalva = feignClient.salvarReceita(receita);
        if (receitaSalva != null) {
            imprimirReceita(receitaSalva);
        }
        return receitaSalva;
    }

    @Override
    public void imprimirReceita(Receita receita) {
        receitaService.imprimir(receita);
    }

    @Override
    public Encaminhamento encaminharPaciente(Encaminhamento encaminhamento) {

        Token token = feignClient.getToken(encaminhamento.getNumToken()).getBody();
        TempoAtendimento  atendimento= feignClient.getTempoAtendimento(token.getNumToken());
        if (encaminhamento.getListaMedicacoes() == null) {
            token.setStatus(AtendimentoStatus.RAIOX);
            producerSender.sendoToRaioX(encaminhamento);

        } else {
            if (encaminhamento.getRegioesRaiox() == null) {
                token.setStatus(AtendimentoStatus.MEDICACAO);
            } else {
                token.setStatus(AtendimentoStatus.MED_RAIOX);
            }
            producerSender.sentoToMedicacaoERaioX(encaminhamento);
        }
        atendimento.setSaidaSaidaDoutor(LocalTime.now());
        feignClient.updateToken(token);
        atendimentoService.atualizarSaidaMedico(atendimento);
        return encaminhamento;
    }

    @Override
    public void adicionarFilaRetornoDoRaioX(Token value) {
        triagem.adicionarFilaRetorno(value);
    }


}
