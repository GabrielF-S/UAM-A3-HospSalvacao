package com.h_salvacao.ms_connect.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class QueueSerializer extends JsonSerializer<Queue<?>> {
    @Override
    public void serialize(Queue<?> tQueue, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        No atual = tQueue.getInicio();
        while (atual != null) {
            jsonGenerator.writeObject(atual.getObject()); atual = atual.getNext();
        }
        jsonGenerator.writeEndArray();

    }
}
