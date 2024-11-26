package com.h_salvacao.ms_triagem.service.impl;

import com.h_salvacao.ms_triagem.model.Ficha;
import com.h_salvacao.ms_triagem.service.TriagemProducerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Log4j2
@Service
@RequiredArgsConstructor
public class TriagemProducerSenderImpl implements TriagemProducerSender {
    public final KafkaTemplate<String, Ficha> kafkaTemplate;

    @Override
    public void sendFicha(Ficha ficha) {
        kafkaTemplate.send("guiche-topic",0, null, ficha).whenComplete((success, error) ->{
            if (error!= null) {
                log.error("Falaha ao enviar: {}", error.getMessage());
            }else {
                log.info("Enviado com sucesso!");
            }
        });

    }
}
