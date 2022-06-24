package com.app.api.controller;

import com.app.api.utils.Endpoints;
import io.restassured.response.Response;

public class DeleteStudentController extends Controller{
    public Response deleteStudent(String id){
        Response response = delete(Endpoints.deleteStudent, id);
        return response;
    }
}
