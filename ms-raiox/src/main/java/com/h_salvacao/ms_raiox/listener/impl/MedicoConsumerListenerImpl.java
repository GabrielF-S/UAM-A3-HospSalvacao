package com.h_salvacao.ms_raiox.listener.impl;

import com.h_salvacao.ms_raiox.listener.MedicoConsumerListener;
import com.h_salvacao.ms_raiox.model.Encaminhamento;
import com.h_salvacao.ms_raiox.service.EncaminhamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MedicoConsumerListenerImpl implements MedicoConsumerListener {
    @Autowired
    private final EncaminhamentoService raioXService;
    @Override
    public void listener(ConsumerRecord<String, Encaminhamento> record) {
        log.info(record.value().getNumToken());
        try {
            raioXService.adicionarFila(record.value());
        }catch (Exception e){
            log.error("Erro ao processar mensagem do Kafka", e);
        }


    }


}
