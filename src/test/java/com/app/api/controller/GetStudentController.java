package com.app.api.controller;

import com.app.api.utils.Endpoints;
import io.restassured.response.Response;

public class GetStudentController extends Controller{
    public Response getStudents(){
        Response response = get(Endpoints.getStudents);
        return response;
    }

    public Response getStudentsWithQueryParam(String query){
        Response response = get(Endpoints.getStudents, query);
        return response;
    }
}
