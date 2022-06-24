package com.app.api.test;

import com.app.api.builder.Student;
import com.app.api.controller.AddStudentController;
import com.app.api.controller.EditStudentController;
import com.app.api.controller.GetStudentController;
import com.app.api.responses.AddStudentResponse;
import com.app.api.responses.EditStudentResponse;
import com.app.api.utils.Helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditStudentTest {
    String[] sub = new String[]{"add", "sub"};

    @Test
    public void editStudentTest() throws JsonProcessingException {
        Helper helper = new Helper();
        Response response = new GetStudentController().getStudents();
        int count = helper.getStudentsCount(response);
        Student studentBuilder = new Student.Builder().setFirstName("Indira")
                .setLastName("Balakrishan")
                .setEmail("mb.indira385@gmail.com")
                .setProgramme("Maths")
                .setCourses(sub)
                .build();
        String objectMapperString = helper.getCreateStudentRequestBody(studentBuilder);
        Response addResponse = new AddStudentController().addStudent(objectMapperString);
        if(addResponse.getStatusCode()==201){
            response = new GetStudentController().getStudents();
            int countAfterAdd = helper.getStudentsCount(response);
            Assert.assertTrue(count+1==countAfterAdd);
            String id = addResponse.getHeader("Location");
            id = id.replace("http://localhost:8085/student/", "");
            Student editStudentBuilder = new Student.Builder().setFirstName("Indira")
                    .setLastName("KMB")
                    .setEmail("mb.indira385@gmail.com")
                    .setProgramme("Maths")
                    .setCourses(sub)
                    .build();
            objectMapperString = helper.getCreateStudentRequestBody(editStudentBuilder);
            Response editResponse = new EditStudentController().editStudent(objectMapperString, id);
            Assert.assertEquals(editResponse.getStatusCode(), 200);
            EditStudentResponse editStudentResponse = new Helper().getEditStudentResponseObject(editResponse);
            Assert.assertEquals(editStudentResponse.getMsg(), "Student Updated");
            response = new GetStudentController().getStudents();
            int countAfterEdit = helper.getStudentsCount(response);
            Assert.assertTrue(count+1==countAfterEdit);
        }
    }
}
