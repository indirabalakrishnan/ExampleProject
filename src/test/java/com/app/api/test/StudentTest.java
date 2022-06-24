package com.app.api.test;

import com.app.api.builder.Student;
import com.app.api.controller.AddStudentController;
import com.app.api.responses.AddStudentResponse;
import com.app.api.utils.Endpoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentTest extends BaseTest{
    String[] sub = new String[]{"add", "sub"};
    @Test
    public void addStudentUsingJsonAsString(){
        String payLoad = "{\"firstName\":\"Indira\",\"lastname\":\"Balakrishnan\",\"email\":\"mb.indira13@gmail.com\",\"programme\":\"maths\",\"courses\":[\"add\",\"sub\"]}";
        Response response = new AddStudentController().addStudent(payLoad);
        Assert.assertEquals(response.getStatusCode(), 201);
        String id = response.header("Location");
        System.out.println(id);
    }

    @Test
    public void addStudentUsingStudentObject() throws JsonProcessingException {
        com.app.api.request.Student student1 = new com.app.api.request.Student();
        student1.setFirstName("Indira");
        student1.setLastName("Balakrishnan");
        student1.setEmail("mb.indira23@gmail.com");
        student1.setProgramme("maths");
        student1.setCourses(sub);
        System.out.println(student1);

        // ObjectMapper to Serialize Object to JSON
        // Deserialize JSON to Object
        ObjectMapper objectMapper = new ObjectMapper();
        String objectString = objectMapper.writeValueAsString(student1);
        System.out.println(objectString);

        Response response = requestSpecification.body(objectString).post(Endpoints.postStudent);
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void addStudentUsingLombokBuilder(){
//        LombokBuilder lombokBuilder = LombokBuilder.builder()
//                .firstName("Indira")
//                .lastName("Balakrishnan")
//                .email("mb.indira40@gmail.com")
//                .programme("Maths")
//                .courses(sub)
//                .build();
//        System.out.println(lombokBuilder.getFirstName());
//        Response response = requestSpecification.body(lombokBuilder).post(Endpoints.postStudent);
//        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void addStudentUsingStudentBuilder() throws JsonProcessingException {
        Student studentBuilder = new Student.Builder().setFirstName("Indira")
                .setLastName("Balakrishan")
                .setEmail("mb.indira38@gmail.com")
                .setProgramme("Maths")
                .setCourses(sub)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String objectMapperString = objectMapper.writeValueAsString(studentBuilder);
        Response response = new AddStudentController().addStudent(objectMapperString);
        Assert.assertEquals(response.getStatusCode(), 201);
        AddStudentResponse addStudentResponse = new ObjectMapper().readValue(response.getBody().prettyPrint(), AddStudentResponse.class);
        Assert.assertEquals(addStudentResponse.getMsg(), "Student added");
    }
}
