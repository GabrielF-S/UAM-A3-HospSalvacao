package com.h_salvacao.ms_triagem.listener.impl;


import com.h_salvacao.ms_triagem.listener.TokenConsumerListener;
import com.h_salvacao.ms_triagem.model.Token;
import com.h_salvacao.ms_triagem.service.TriagemService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TokenConsumerListenerImpl implements TokenConsumerListener {

    private final TriagemService triagemService;
    @Override
    public void listener(ConsumerRecord<String, Token> record) {
        triagemService.adcionarFila(record.value());
    }


}
