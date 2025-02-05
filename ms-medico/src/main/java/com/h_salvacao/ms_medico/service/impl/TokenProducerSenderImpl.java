package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.model.Token;
import com.h_salvacao.ms_medico.service.TokenProducerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class TokenProducerSenderImpl implements TokenProducerSender {
    public final KafkaTemplate<String, Token> kafkaTemplateToken;
    @Override
    public void sendoToAtendimento(Token token) {
        kafkaTemplateToken.send("atendimento-topic", 0, null, token).whenComplete((success, error) -> {
            if (error != null) {
                log.error("Falaha ao enviar: {}", error.getMessage());
            } else {
                log.info("Enviado com sucesso!");
            }
        });

    }
}
