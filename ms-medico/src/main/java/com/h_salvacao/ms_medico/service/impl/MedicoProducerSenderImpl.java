package com.h_salvacao.ms_medico.service.impl;

import com.h_salvacao.ms_medico.model.Encaminhamento;
import com.h_salvacao.ms_medico.model.Token;
import com.h_salvacao.ms_medico.service.MedicoProducerSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MedicoProducerSenderImpl implements MedicoProducerSender {
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
    public void sentoToMedicacaoERaioX(Encaminhamento encaminhamento) {
        kafkaTemplateEncaminhamento.send("intravenosa-topic", 0, null, encaminhamento).whenComplete((success, error) -> {
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
