package com.app.api.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class JsonAnnotations {
    String json = "{\"age\":35,\"salary\":0,\"NAME\":\"Indira\"}";

    @Test
    public void serialiseWithJacksonAnnotationsTest() throws JsonProcessingException {
        Dto dto = new Dto();
        dto.setFirstName("Indira");
        dto.setAge(35);
        dto.setDegree("MCA");
        String json = new ObjectMapper().writeValueAsString(dto);
        System.out.println(json);
    }

    @Test
    public void deSerialiseWithJacksonAnnotationsTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Dto dto = objectMapper.readValue(json, Dto.class);
        System.out.println(dto);
    }
}
