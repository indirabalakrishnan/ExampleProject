package com.app.api.test;

import com.app.api.utils.Constants;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    RequestSpecification requestSpecification;
    @BeforeTest
    public void setUp(){
        requestSpecification = RestAssured.given().baseUri(Constants.HOST).contentType("application/json");
    }
}
