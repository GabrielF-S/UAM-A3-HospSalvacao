package com.h_salvacao.ms_medicacao.listener.impl;

import com.h_salvacao.ms_medicacao.listener.EncaminhamentoConsumerListener;
import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import com.h_salvacao.ms_medicacao.services.EncaminhamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class EncaminhamentoConsumerListenerImpl implements EncaminhamentoConsumerListener {

    @Autowired
    EncaminhamentoService service;

    @Override
    public void listener(ConsumerRecord<String, Encaminhamento> record) {
        log.info(record.value().getNumToken());
          try {

            service.adicionarFila(record.value());
        }catch (Exception e){
            log.error("Erro ao processar mensagem do Kafka", e);
        }


    }


}
