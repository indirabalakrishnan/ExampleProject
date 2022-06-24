package com.app.api.builder;

import java.util.Arrays;

public class Student {
    public String firstName;
    public String lastName;
    public String email;
    public String programme;
    public String[] courses;

    public static class Builder{
        public Student student;

        public Builder(){
            student = new Student();
        }
        public Builder setFirstName(String firstName){
            student.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            student.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email){
            student.email = email;
            return this;
        }

        public Builder setProgramme(String programme){
            student.programme = programme;
            return this;
        }

        public Builder setCourses(String[] courses){
            student.courses = courses;
            return this;
        }

        public Student build(){
            return this.student;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", programme='" + programme + '\'' +
                ", courses=" + Arrays.toString(courses) +
                '}';
    }
}
