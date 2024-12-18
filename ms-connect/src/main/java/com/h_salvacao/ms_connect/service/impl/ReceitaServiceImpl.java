package com.h_salvacao.ms_connect.service.impl;

import com.h_salvacao.ms_connect.entity.Receita;
import com.h_salvacao.ms_connect.repository.ReceitaRepository;
import com.h_salvacao.ms_connect.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaServiceImpl implements ReceitaService {

    @Autowired
    ReceitaRepository receitaRepo;


    @Override
    public Receita save(Receita receita) {
        return receitaRepo.save(receita);
    }
}
