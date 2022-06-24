package com.app.builder;

public class UserBuilder {
    private String name;
    private int age;
    private String designation;

    public UserBuilder setName(String name){
        this.name = name;
        return this;
    }

    public UserBuilder setDesignation(String designation){
        this.designation = designation;
        return this;
    }

    public UserBuilder setAge(int age){
        this.age = age;
        return this;
    }



}
