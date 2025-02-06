package com.h_salvacao.ms_medico.listener.impl;

import com.h_salvacao.ms_medico.listener.TokenConsumerListener;
import com.h_salvacao.ms_medico.model.Token;
import com.h_salvacao.ms_medico.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TokenConsumerListenerImpl implements TokenConsumerListener {
    private final TokenService medicoService;

    @Override
    public void listenerRegular(ConsumerRecord<String, Token> record) {
        log.info(record.value().getNumToken());
        try {
            record.value().setRetorno(false);
            medicoService.adicionarFila(record.value());
        }catch (Exception e){
            log.error("Erro ao processar mensagem do Kafka", e);
        }


    }

    @Override
    public void listenerReturn(ConsumerRecord<String, Token> record) {
        log.info(record.value().getNumToken());
        try {

            medicoService.adicionarFilaRetornoDoRaioX(record.value());
        }catch (Exception e){
            log.error("Erro ao processar mensagem do Kafka", e);
        }

    }
}
