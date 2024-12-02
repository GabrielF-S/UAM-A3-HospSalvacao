package com.h_salvacao.ms_connect.service.impl;

import com.h_salvacao.ms_connect.entity.Ficha;
import com.h_salvacao.ms_connect.repository.FichaRepository;
import com.h_salvacao.ms_connect.service.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FichaServiceImpl implements FichaService {

    @Autowired
    FichaRepository fichaRepository;
    @Override
    public Ficha salvarFicha(Ficha ficha) {
        return fichaRepository.save(ficha);

    }

    @Override
    public Ficha getFicha(Long tokenId) {
        return  fichaRepository.findByNumToken(tokenId).get();
    }

    @Override
    public Ficha atualizarFicha(Ficha ficha) {
        return  fichaRepository.save(ficha);
    }
}
