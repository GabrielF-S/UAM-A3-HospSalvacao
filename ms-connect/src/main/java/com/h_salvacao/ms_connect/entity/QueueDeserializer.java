package com.h_salvacao.ms_connect.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class QueueDeserializer extends JsonDeserializer<Queue<?>> {

    @Override
    public Queue<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Queue<Object> queue = new Queue<>();

        for (JsonNode item : node) {
            Object value = jsonParser.getCodec().treeToValue(item, Object.class);
            queue.enqueue(value);
        }
        return queue;
    }
}
