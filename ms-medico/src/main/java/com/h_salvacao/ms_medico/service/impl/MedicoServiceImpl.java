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
        return triagem.getFila().size();
    }

    @Override
    public Token chamarProximo() {
        try {
            String numToken = triagem.getFila().dequeue().getNumToken();
            Token token = feignClient.getToken(numToken).getBody();
            if (token.getStatus() == AtendimentoStatus.DOUTOR){
               producerSender.sendoToAtendimento(token);
                return token;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return new Token(0L,"0", LocalDateTime.now(), null, AtendimentoStatus.DESCONHECIDO, TipoAtendimento.DESCONHECIDO);

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
        if (receitaSalva != null){
            imprimirReceita(receitaSalva);
        }
        return receitaSalva;
    }

    @Override
    public void imprimirReceita(Receita receita) {
        receitaService.imprimir(receita);
    }


}
