package com.app.api.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonSerialiseAndDeserialise {
    Map<String, String> payLoad = new HashMap<String, String>();
    String json = "{\"modelName\":\"Maruti\",\"modelNo\":800}";
    String jsonArray = "[{\"modelName\":\"Maruti\",\"modelNo\":800}, {\"modelName\":\"MarutiZen\",\"modelNo\":1000}]";

    // Serialize
    @Test
    public void hashMapToJsonTest() throws JsonProcessingException {
        payLoad.put("name", "Indira");
        payLoad.put("age", "20");
        System.out.println(new ObjectMapper().writeValueAsString(payLoad));
    }

    @Test
    public void objectToJsonTest() throws JsonProcessingException {
        Car car = new Car();
        car.setModelName("Maruti");
        car.setModelNo(800);
        System.out.println(new ObjectMapper().writeValueAsString(car));
    }

    //Deserialize
    @Test
    public void jsonToObjectTest() throws JsonProcessingException {
        Car car = new ObjectMapper().readValue(json, Car.class);
        System.out.println(car.modelName + " " + car.modelNo);
    }

    @Test
    public void jsonToJsonNodeTest() throws JsonProcessingException {
        JsonNode jsonNode = new ObjectMapper().readTree(json);
        System.out.println(jsonNode.get("modelName") + " " + jsonNode.get("modelNo"));
    }

    @Test
    public void jsonArrayToObjectTest() throws JsonProcessingException {
        List<Car> cars = new ObjectMapper().readValue(jsonArray, new TypeReference<List<Car>>(){});
        System.out.println(cars.toString());
        System.out.println(cars.get(0).modelName + " " + cars.get(0).modelNo);
        System.out.println(cars.get(1).modelName + " " + cars.get(1).modelNo);
    }

    @Test
    public void jsonToHashMap() throws JsonProcessingException {
        Map<String, String> hashMap = new ObjectMapper().readValue(json, new TypeReference<HashMap<String, String>>(){});
        System.out.println(hashMap.get("modelName") + " " + hashMap.get("modelNo"));
    }

}
