package com.h_salvacao.ms_connect.service;

import com.h_salvacao.ms_connect.entity.Encaminhamento;
import org.springframework.http.ResponseEntity;

public interface EncaminhamentoService {

    Encaminhamento save(Encaminhamento encaminhamento);

    Encaminhamento getEncaminhamento(String numToken);

    Encaminhamento updateEncaminhamento(Encaminhamento encaminhamento);
}
