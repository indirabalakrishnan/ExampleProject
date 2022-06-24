package com.app.api.controller;

import com.app.api.utils.Endpoints;
import io.restassured.response.Response;

public class AddStudentController extends Controller{
    public Response addStudent(String payload){
        Response response = post(Endpoints.postStudent, payload);
        return response;
    }
}
