package com.app.api.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class JacksonDeserialiseExceptionsHandling {
    String json = "{\"modelName\":\"Maruti\",\"modelNo\":800, \"Year\":2022}";
    String jsonArray = "[{\"modelName\":\"Maruti\",\"modelNo\":800}, {\"modelName\":\"MarutiZen\",\"modelNo\":1000}]";
    String carPurchaseJsonArray = "[{\"car\":{\"modelName\":\"Marti\",\"modelNo\":800},\"dataPurchased\":\"2022.06.24 AD at 10:14:21 IST\"}, " +
            "{\"car\":{\"modelName\":\"MartiZen\",\"modelNo\":100},\"dataPurchased\":\"2022.06.24 AD at 10:14:21 IST\"}]";

    //For unrecognised Property Exception, adding annotations in class worked
    //@JsonIgnoreProperties(ignoreUnknown = true)
    @Test
    public void jsonToObjectWithUnrecognisedProperty() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(json, Car.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        System.out.println(car.modelName + " " + car.modelNo);
    }

    @Test
    public void dateFormatInJsonSerialisation() throws JsonProcessingException {
        // Object Mapper
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(dateFormat);

        //Car Object
        Car car = new Car();
        car.setModelName("Marti");
        car.setModelNo(800);

        // CarPurchase Object
        CarPurchase carPurchase = new CarPurchase();
        carPurchase.setCar(car);
        carPurchase.setDataPurchased(new Date());

        //This will print date in Dateformat specified in the ObjectMapper
        String json = objectMapper.writeValueAsString(carPurchase);
        System.out.println(json);
    }

    @Test
    public void jsonArrayDeserialiseToWrapperClass() throws JsonProcessingException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        List<CarPurchase> carPurchases = new ObjectMapper().setDateFormat(dateFormat).readValue(carPurchaseJsonArray, new TypeReference<List<CarPurchase>>(){});
        System.out.println(carPurchases.get(0).getCar());
        System.out.println(carPurchases.get(1).getCar());
        System.out.println(carPurchases.get(0).getDataPurchased());
        System.out.println(carPurchases.get(1).getDataPurchased());
        System.out.println(carPurchases);
    }

}
