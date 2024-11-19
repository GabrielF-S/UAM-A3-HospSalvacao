package com.h_salvacao.ms_triagem.listener.impl;


import com.h_salvacao.ms_triagem.entity.Token;
import com.h_salvacao.ms_triagem.listener.TokenConsumerListener;
import com.h_salvacao.ms_triagem.service.TriagemService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.Acknowledgment;


@Service
@RequiredArgsConstructor
public class TokenConsumerListenerImpl implements TokenConsumerListener {

    private final TriagemService triagemService;
    @Override
    public void listener(ConsumerRecord<String, Token> record) {
        System.out.println("recebido token: " + record.value().getNumToken());
        triagemService.adcionarFila(record.value());




    }
}
