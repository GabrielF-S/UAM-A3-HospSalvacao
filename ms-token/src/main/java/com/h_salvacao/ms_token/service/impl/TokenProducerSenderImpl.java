package com.h_salvacao.ms_token.service.impl;

import com.h_salvacao.ms_token.entity.Token;
import com.h_salvacao.ms_token.service.TokenProducerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TokenProducerSenderImpl implements TokenProducerSender {
    public final KafkaTemplate<String, Token> kafkaTemplate;

    @Override
    public void sendToken(Token token) {

        kafkaTemplate.send("triagem-topic", token)
                .whenComplete((success, error) -> {
                    if (error!= null) {
                        log.error("Falaha ao enviar: {}", error.getMessage());
                    }else {
                        log.info("Enviado com sucesso!");
                    }
                });


    }
}
