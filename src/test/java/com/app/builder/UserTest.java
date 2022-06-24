package com.app.builder;

public class UserTest {
    public static void main(String[] args) {
        User user = new User.Builder().setName("Indira").setAge(35).setDesignation("Lead").build();
        System.out.println(user);
    }
}
