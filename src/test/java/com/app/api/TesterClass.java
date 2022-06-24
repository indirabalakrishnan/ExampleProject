package com.app.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TesterClass {
    public static void main(String[] args) {
        String body = "Student{firstName='Indira', lastName='Balakrishan', email='mb.indira@gmail.com', programme='Maths', courses=[add, sub]}";
        RequestSpecification requestSpecification = RestAssured.given().baseUri("http://localhost:8085");
        Response response = requestSpecification.body(body).post("/student");
        System.out.println(requestSpecification.toString());
        System.out.println(response.asString());
    }
}
