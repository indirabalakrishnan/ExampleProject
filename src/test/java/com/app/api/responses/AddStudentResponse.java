package com.app.api.responses;

public class AddStudentResponse {
    public String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "AddStudentResponse{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
