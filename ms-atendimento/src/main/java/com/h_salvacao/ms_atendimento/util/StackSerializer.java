package com.h_salvacao.ms_atendimento.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.h_salvacao.ms_atendimento.model.Token;

import java.io.IOException;

public class StackSerializer extends JsonSerializer<Stack<Token>> {
    @Override
    public void serialize(Stack<Token> stack, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        No atual = stack.getTopo();
        while (atual != null) {
            jsonGenerator.writeObject(atual.dado); atual = atual.proximo;
        } jsonGenerator.writeEndArray();

    }
}
