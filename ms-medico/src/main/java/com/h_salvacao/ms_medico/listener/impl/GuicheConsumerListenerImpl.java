package com.h_salvacao.ms_medico.listener.impl;

import com.h_salvacao.ms_medico.listener.GuicheConsumerListener;
import com.h_salvacao.ms_medico.model.Token;
import com.h_salvacao.ms_medico.service.MedicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class GuicheConsumerListenerImpl implements GuicheConsumerListener {
    private final MedicoService medicoService;
    @Override
    public void listener(ConsumerRecord<String, Token> record) {
        System.out.println(record.value().getNumToken());
        try {

            medicoService.adicionarFila(record.value());
        }catch (Exception e){
            log.error("Erro ao processar mensagem do Kafka", e);
        }


    }
}
