package com.h_salvacao.ms_connect.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


import java.io.IOException;

@Converter
public class QueueConverter implements AttributeConverter<Queue<Medicacao>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Queue<Medicacao> queue) {
        try {
            return objectMapper.writeValueAsString(queue);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter Queue<Medicacao> para String", e);
        }
    }

    @Override
    public Queue<Medicacao> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, Queue.class);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao converter String para Queue<Medicacao>", e);
        }
    }
}
