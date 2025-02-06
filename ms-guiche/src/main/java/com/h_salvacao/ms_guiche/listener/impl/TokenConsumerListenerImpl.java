package com.h_salvacao.ms_guiche.listener.impl;

import com.h_salvacao.ms_guiche.listener.TokenConsumerListener;
import com.h_salvacao.ms_guiche.model.Token;
import com.h_salvacao.ms_guiche.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;
@Log4j2
@Service
@RequiredArgsConstructor
public class TokenConsumerListenerImpl implements TokenConsumerListener {
    private final TokenService guicheService;

    @Override
    public void listener(ConsumerRecord<String, Token> record) {
        System.out.println(record.value().getNumToken());
        try {

        guicheService.adicionarFila(record.value());
        }catch (Exception e){
            log.error("Erro ao processar mensagem do Kafka", e);
        }

    }
}
