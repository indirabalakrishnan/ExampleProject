package com.app.builder;

public class User {

    private String name;
    private int age;
    private String designation;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                '}';
    }

    public static class Builder {

        private User user;

        public Builder() {
            user = new User();
        }

        public Builder setName(String name){
            user.name = name;
            return this;
        }

        public Builder setDesignation(String designation){
            user.designation = designation;
            return this;
        }

        public Builder setAge(int age){
            user.age = age;
            return this;
        }

        public User build(){
            return this.user;
        }
    }
}
