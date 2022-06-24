package com.app.api.controller;

import com.app.api.utils.Constants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Controller {

    public RequestSpecification requestSpecification;
    public String baseUri = Constants.HOST;

    public Controller(){
        this.requestSpecification = RestAssured.given().baseUri(baseUri).contentType("application/json");
    }

    public Response post(String url, String body){
        Response response = requestSpecification.body(body).post(url);
        return response;
    }

    public Response get(String url){
        Response response = requestSpecification.get(url);
        return response;
    }

    public Response get(String url, String query){
        Response response = requestSpecification.queryParam("programme", query).get(url);
        return response;
    }

    public Response put(String url, String body, String id){
        url = url.replace("%s", id);
        Response response = requestSpecification.body(body).put(url);
        return response;
    }

    public Response delete(String url, String id){
        url = url.replace("%s", id);
        Response response = requestSpecification.delete(url);
        return response;
    }
}
