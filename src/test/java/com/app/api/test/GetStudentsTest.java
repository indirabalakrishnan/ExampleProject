package com.app.api.test;

import com.app.api.builder.Student;
import com.app.api.controller.GetStudentController;
import com.app.api.utils.Helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class GetStudentsTest extends BaseTest {
    @Test
    public void getStudentsListTest() throws JsonProcessingException {
        Response response = new GetStudentController().getStudents();
        Assert.assertEquals(response.getStatusCode(), 200);
        Student[] students = new Helper().getStudentsFromResponse(response);
        System.out.println(students.length);
    }

    //Student Array
    @Test
    public void getStudentsArrayWithQueryParamTest() throws JsonProcessingException {
        String query = "medicine";
        Response response = new GetStudentController().getStudentsWithQueryParam(query);
        Assert.assertEquals(response.getStatusCode(), 200);
        Student[] students = new Helper().getStudentsFromResponse(response);
        System.out.println(students.length);
        System.out.println(Arrays.stream(students).findFirst().get().email);
    }

    //Student List
    @Test
    public void getStudentsListWithQueryParamTest() throws JsonProcessingException {
        String query = "medicine";
        Response response = new GetStudentController().getStudentsWithQueryParam(query);
        Assert.assertEquals(response.getStatusCode(), 200);
        List<Student> students = new Helper().getStudentsListFromResponse(response);
        System.out.println(students.size());
        System.out.println(students.get(0).email);
    }
}
