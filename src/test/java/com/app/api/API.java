package com.app.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojo.Student;
import java.util.ArrayList;

//                  logger.info(response.prettyPrint());
//                ValidatableResponse validatableResponse = response.then();
//                validatableResponse.statusCode(200);

public class API {
    Logger logger = LogManager.getLogger(API.class);
    @Test
    public void getAllStudents(){
        RequestSpecification requestSpecification = RestAssured.given().baseUri("http://localhost:8085/");
        Response response = requestSpecification
                .queryParam("programme", "medicines")
                .get("student/list");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void getAllStudentList(){
        RestAssured.given()
                .baseUri("http://localhost:8085/")
                .when()
                .get("student/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void getAllStudentsWithQueryParam(){
        RestAssured.given()
                .baseUri("http://localhost:8085/")
                .when()
                .queryParam("programme", "medicines")
                .get("student/list")
                .then()
                .statusCode(200);
    }

    String payload = "{\"firstName\":\"Indira\",\"lastname\":\"Balakrishnan\",\"email\":\"mb.indira3@gmail.com\",\"programme\":\"maths\",\"courses\":[\"add\",\"sub\"]}";

    @Test
    public void postNewCustomer(){
        RestAssured.given()
                .baseUri("http://localhost:8085/")
                .contentType("application/json")
                .when()
                .log().all()
                .basePath("student")
                .body(payload)
                .post()
                .then().statusCode(201);

    }

    @Test
    public void postNewCustomer2(){
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.baseUri("http://localhost:8085/")
                .contentType("application/json")
                .basePath("student")
                .body(payload)
                .post();
        Assert.assertTrue(response.asString().contains("Email address already exists"));
        Assert.assertEquals(500, response.statusCode());

        System.out.println(response.asString());
    }

    @Test
    public void postNewCustomer3(){
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.baseUri("http://localhost:8085/")
                .contentType("application/json")
                .basePath("student")
                .body(getStudentObject())
                .post();
        Assert.assertEquals(201, response.statusCode());
    }

    public Student getStudentObject(){
        Student student = new Student();
        student.setFirstName("Rishaan");
        student.setLastname("Rajesh");
        student.setEmail("mb.indira5@gmail.com");
        student.setProgramme("maths");
        ArrayList<String> courses = new ArrayList<>();
        courses.add("add");
        courses.add("sub");
        student.setCourses(courses);
        return student;
    }

    public Student getStudentObject(String string){
        Student student = new Student();
        student.setFirstName("Tom"+string);
        student.setLastname("Cruise"+string);
        student.setEmail("tom.cruise"+string+"@gmail.com");
        student.setProgramme("maths");
        ArrayList<String> courses = new ArrayList<>();
        courses.add("add");
        courses.add("sub");
        student.setCourses(courses);
        return student;
    }

    @Test
    public void putEditCustomer(){
        Student student = getStudentObject();
        student.setLastname("Edited");

        RestAssured.given()
                .baseUri("http://localhost:8085/")
                .contentType("application/json")
                .accept("application/json")
                .when()
                .log().all()
                .basePath("student")
                .body(student)
                .put("/113")
                .then().statusCode(200);
    }

    @Test
    public void putEditCustomerDetails(){
        Student student = getStudentObject();
        student.setLastname("Edited");

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.baseUri("http://localhost:8085/")
                .contentType(ContentType.JSON)
                .basePath("student")
                .body(student)
                .put("/113");
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void deleteStudent(){
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.baseUri("http://localhost:8085/")
                .basePath("student")
                .delete("/112");
        Assert.assertEquals(204, response.statusCode());
    }

    @Test
    public void postNewStudent(){
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.baseUri("http://localhost:8085/")
                .contentType("application/json")
                .basePath("student")
                .body(getStudentObject(generateRandomString()))
                .post();
        Assert.assertEquals(201, response.statusCode());
    }

    @Test
    public void getStudentsCall(){
        RequestSpecification requestSpecification = RestAssured.given().baseUri("http://localhost:8085/");
        Response response = requestSpecification.get("student/list");
        System.out.println(response.getBody());
        JSONObject jsonObject = new JSONObject(response.getBody());
        System.out.println(jsonObject.getJSONObject("firstName").get("firstName").toString());
    }

   public int generateRandomNosBetweenGivenNumbers(){
        double num = Math.random();
        int min = 1000;
        int max = 2000;
        return (int)(num * (max-min+1)+min);
    }

    public String generateRandomString(){
        return RandomStringUtils.random(5, true, true);
    }
}
