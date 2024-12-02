package com.h_salvacao.ms_triagem.listener.impl;


import com.h_salvacao.ms_triagem.listener.TokenConsumerListener;
import com.h_salvacao.ms_triagem.model.Token;
import com.h_salvacao.ms_triagem.service.TriagemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TokenConsumerListenerImpl implements TokenConsumerListener {

    private final TriagemService triagemService;
    @Override
    public void listener(ConsumerRecord<String, Token> record) {
        log.info("Recebido token: " + record.value().getNumToken());
        triagemService.adcionarFila(record.value());
    }


}
