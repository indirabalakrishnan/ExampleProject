package com.app.api.responses;

public class EditStudentResponse {
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "EditStudentResponse{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public String msg;
}
