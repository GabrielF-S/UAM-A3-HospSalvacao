package com.h_salvacao.ms_guiche.service.impl;

import com.h_salvacao.ms_guiche.model.Token;
import com.h_salvacao.ms_guiche.service.GuicheProducerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class GuicheProducerSenderImpl implements GuicheProducerSender {

    private final KafkaTemplate<String, Token> kafkaTemplate;
    @Override
    public void send(Token token) {
        kafkaTemplate.send("medico-topic", 0, null, token).whenComplete((success, error) ->{
                    if (error!= null) {
                        log.error("Falaha ao enviar: {}", error.getMessage());
                    }else {
                        log.info("Enviado com sucesso!");
                    }
                }

        );

    }

    @Override
    public void sendoToAtendimento(Token token) {
        kafkaTemplate.send("atendimento-topic",0, null, token).whenComplete((success, error) ->{
            if (error!= null) {
                log.error("Falaha ao enviar: {}", error.getMessage());
            }else {
                log.info("Enviado com sucesso!");
            }
        });

    }
}
