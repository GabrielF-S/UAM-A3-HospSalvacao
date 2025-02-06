package com.h_salvacao.ms_atendimento.listener.impl;

import com.h_salvacao.ms_atendimento.listener.TokenConsumerListener;
import com.h_salvacao.ms_atendimento.model.Token;
import com.h_salvacao.ms_atendimento.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TokenConsumerListenerImpl implements TokenConsumerListener {

    private final TokenService atendimentoService;

    @Override
    public void listener(ConsumerRecord<String, Token> record) {
        log.info("Token recebido:: " + record.value().getNumToken());
        log.info(record.topic());
        atendimentoService.adicionarPilha(record.value());


    }
}
