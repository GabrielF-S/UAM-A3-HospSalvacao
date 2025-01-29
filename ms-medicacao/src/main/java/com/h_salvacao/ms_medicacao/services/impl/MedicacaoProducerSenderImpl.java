package com.h_salvacao.ms_medicacao.services.impl;

import com.h_salvacao.ms_medicacao.model.Encaminhamento;
import com.h_salvacao.ms_medicacao.model.Token;
import com.h_salvacao.ms_medicacao.services.MedicacaoProducerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MedicacaoProducerSenderImpl implements MedicacaoProducerSender {
    public final KafkaTemplate<String, Encaminhamento> kafkaTemplateEncaminhamento;

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

    @Override
    public void sentoToMedico(Token token) {
        kafkaTemplateToken.send("medico-topic", 0, null, token).whenComplete((success, error) -> {
            if (error != null) {
                log.error("Falaha ao enviar: {}", error.getMessage());
            } else {
                log.info("Enviado com sucesso!");
            }
        });

    }

    @Override
    public void sendoToRaioX(Encaminhamento encaminhamento) {
        kafkaTemplateEncaminhamento.send("raiox-topic", 0, null, encaminhamento).whenComplete((success, error) -> {
            if (error != null) {
                log.error("Falaha ao enviar: {}", error.getMessage());
            } else {
                log.info("Enviado com sucesso!");
            }
        });
    }
}
