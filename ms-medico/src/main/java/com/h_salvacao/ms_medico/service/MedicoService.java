package com.h_salvacao.ms_medico.service;

import com.h_salvacao.ms_triagem.model.Token;
import com.h_salvacao.ms_medico.feign.TriagemFeignClient;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    private final TriagemFeignClient triagemFeignClient;

    public MedicoService(TriagemFeignClient triagemFeignClient) {
        this.triagemFeignClient = triagemFeignClient;
    }

    public Token chamarMedico() {
        Token primeiroElemento = triagemFeignClient.chamarMedico();

        if (primeiroElemento == null) {
            System.out.println("A fila está vazia.");
        }

        return primeiroElemento;
    }
}

