package com.app.api.controller;

import com.app.api.utils.Endpoints;
import io.restassured.response.Response;

public class EditStudentController extends Controller{
    public Response editStudent(String payload, String id){
        Response response = put(Endpoints.editStudent, payload, id);
        return response;
    }
}
