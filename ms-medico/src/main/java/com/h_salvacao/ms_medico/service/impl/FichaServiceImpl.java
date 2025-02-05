package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.feignCliente.FichaFeignClient;
import com.h_salvacao.ms_medico.model.Ficha;
import com.h_salvacao.ms_medico.service.FichaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FichaServiceImpl implements FichaService {

    private final FichaFeignClient fichaFeignClient;
    @Override
    public Ficha getFicha(Long tokenId) {
        return fichaFeignClient.getFicha(tokenId);
    }

    @Override
    public Ficha atulizarFicha(Ficha ficha) {
        return fichaFeignClient.atulizarFicha(ficha);
    }
}
