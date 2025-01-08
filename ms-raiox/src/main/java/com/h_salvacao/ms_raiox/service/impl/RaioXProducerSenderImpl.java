package com.h_salvacao.ms_raiox.service.impl;

import com.h_salvacao.ms_raiox.model.Encaminhamento;
import com.h_salvacao.ms_raiox.model.Token;
import com.h_salvacao.ms_raiox.service.RaioXProducerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class RaioXProducerSenderImpl implements RaioXProducerSender {
    public final KafkaTemplate<String, Token> kafkaTemplateEncaminhamento;
    @Override
    public void senToMedico(Token token) {
        kafkaTemplateEncaminhamento.send("retorno-topic", 0, null, token).whenComplete((success, error) -> {
            if (error != null) {
                log.error("Falaha ao enviar: {}", error.getMessage());
            } else {
                log.info("Enviado com sucesso!");
            }
        });

    }
}
