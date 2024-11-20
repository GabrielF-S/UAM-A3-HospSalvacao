package com.h_salvacao.ms_triagem.listener.impl;


import com.h_salvacao.ms_triagem.model.Token;
import com.h_salvacao.ms_triagem.listener.TokenConsumerListener;
import com.h_salvacao.ms_triagem.service.TriagemService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TokenConsumerListenerImpl implements TokenConsumerListener {

    private final TriagemService triagemService;
    @Override
    public void listener(ConsumerRecord<String, Token> record) {


        System.out.println("recebido token: " + record.value().getNumToken() + "\n Atendimento: " + record.value().getAtendimento());


        triagemService.adcionarFila(record.value());



    }

//    @Override
//    public void listener2(ConsumerRecords<String, Token> records) {
//        records.records("triagem-topic").forEach( t ->{
//            System.out.println(t.value());
//
//        });
//    }
}
