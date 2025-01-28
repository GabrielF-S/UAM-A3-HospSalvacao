package com.h_salvacao.ms_medicacao.services.impl;

import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import com.h_salvacao.ms_medicacao.model.Queue;
import com.h_salvacao.ms_medicacao.services.MedicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicacaoServiceImpl implements MedicacaoService {
    @Autowired
    Queue<Encaminhamento> lista;

    public void adicionarFila(Encaminhamento encaminhamento){
        lista.enqueue(encaminhamento);
    }

}
