package com.app.api.utils;

import com.app.api.builder.Student;
import com.app.api.responses.AddStudentResponse;
import com.app.api.responses.EditStudentResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.response.Response;

import java.util.List;

public class Helper {
    public Student[] getStudentsFromResponse(Response response) throws JsonProcessingException {
        Student[] students = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(response.getBody().prettyPrint(), new TypeReference<Student[]>(){});
        return students;
    }

    public List<Student> getStudentsListFromResponse(Response response) throws JsonProcessingException {
        List<Student> students = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(response.getBody().prettyPrint(), new TypeReference<List<Student>>(){});
        return students;
    }

    public String getCreateStudentRequestBody(Student student) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String objectMapperString = objectMapper.writeValueAsString(student);
        return objectMapperString;
    }

    public AddStudentResponse getStudentResponseObject(Response response) throws JsonProcessingException {
        return new ObjectMapper().readValue(response.getBody().prettyPrint(), AddStudentResponse.class);
    }

    public EditStudentResponse getEditStudentResponseObject(Response response) throws JsonProcessingException {
        return new ObjectMapper().readValue(response.getBody().prettyPrint(), EditStudentResponse.class);
    }

    public int getStudentsCount(Response response) throws JsonProcessingException {
        return getStudentsFromResponse(response).length;
    }
}
