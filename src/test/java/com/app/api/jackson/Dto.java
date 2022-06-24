package com.app.api.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dto {
    @JsonProperty("NAME")
    public String firstName;
    public int age;
    @JsonIgnore
    public String degree;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String address;
    public int salary;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String spouse;

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Dto{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", degree='" + degree + '\'' +
                ", address='" + address + '\'' +
                ", salary='" + salary + '\'' +
                ", spouse='" + spouse + '\'' +
                '}';
    }
}
