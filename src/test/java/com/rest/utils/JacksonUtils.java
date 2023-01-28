package com.rest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JacksonUtils {
    private ObjectMapper mapper;

    public void init(){
        mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .registerModule(new JodaModule())
                .registerModule(new JavaTimeModule())
                .enable(SerializationFeature.INDENT_OUTPUT);
    }

    public String toJson(Object source){
        try{
            return mapper.writeValueAsString(source);
        } catch (JsonProcessingException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public <T> T fromJson(String json, Class<T> temp){
        try {
            return mapper.readValue(json, temp);
        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
