package com.h_salvacao.ms_connect.service.impl;

import com.h_salvacao.ms_connect.entity.Encaminhamento;
import com.h_salvacao.ms_connect.exceptions.EncaminhamentoException;
import com.h_salvacao.ms_connect.repository.EncaminhamentoRepository;
import com.h_salvacao.ms_connect.service.EncaminhamentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EncaminhamentoServiceImpl implements EncaminhamentoService {
    private final EncaminhamentoRepository encaminhamentoRepository;
    @Override
    public Encaminhamento save(Encaminhamento encaminhamento) {
        if (encaminhamento == null){
            throw  new EncaminhamentoException();
        }
        return encaminhamentoRepository.save(encaminhamento);
    }

    @Override
    public Encaminhamento getEncaminhamento(String numToken) {
        return encaminhamentoRepository.findBynumToken(numToken).get();
    }
}
