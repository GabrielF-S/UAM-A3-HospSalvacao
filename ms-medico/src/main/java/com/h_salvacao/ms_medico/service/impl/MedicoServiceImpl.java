package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.feignCliente.MedicoFeignClient;
import com.h_salvacao.ms_medico.model.*;
import com.h_salvacao.ms_medico.service.ImprimirReceitaService;
import com.h_salvacao.ms_medico.service.MedicoProducerSender;
import com.h_salvacao.ms_medico.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    Triagem triagem;

    @Autowired
    ImprimirReceitaService receitaService;

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
        try {
            String numToken = triagem.getFila().dequeue().getNumToken();
            Token token = feignClient.getToken(numToken).getBody();
            if (token.getStatus() == AtendimentoStatus.DOUTOR) {
                producerSender.sendoToAtendimento(token);
                return token;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return new Token(0L, "0", LocalDateTime.now(), null, AtendimentoStatus.DESCONHECIDO, TipoAtendimento.DESCONHECIDO);

    }

    private Token getProximo() {
        if (getTotal() > 0) {
            String numToken = verificarFilas().getNumToken();
        }
    }

    private Token verificarFilas() {
        Token tokenComun, tokenRetorno;
        if (triagem.getFila().checkFirst() != null && triagem.getFilaRetorno().checkFirst() == null){
            return triagem.getFila().dequeue();
        }
        if (triagem.getFila().checkFirst()== null && triagem.getFilaRetorno().checkFirst() != null){
            return triagem.getFilaRetorno().dequeue();
        }
        if (triagem.getFila().checkFirst() != null && triagem.getFilaRetorno().checkFirst() != null){
            tokenComun = triagem.getFila().checkFirst();
            tokenRetorno = triagem.getFilaRetorno().checkFirst();
            getComumOuRetorno(tokenComun, tokenRetorno);
        }
    }

    private void getComumOuRetorno(Token tokenComun, Token tokenRetorno) {
        
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
        feignClient.updateToken(token);
        return encaminhamento;
    }

    @Override
    public void adicionarFilaRetorno(Token value) {
        triagem.adicionarFilaRetorno(value);
    }


}
