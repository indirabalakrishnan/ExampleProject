package com.app.testNGAnnotations;

import org.testng.annotations.*;

public class BaseTest {
    @BeforeClass
    public void doBeforeClass(){
    System.out.println("I am at Before Class");
    }

    @BeforeMethod
    public void doBeforeMethod(){
        System.out.println("I am at Before Method");
    }

    @BeforeTest
    public void doBeforeTest(){
        System.out.println("I am at Before TEST");
    }

    @AfterTest
    public void doAfterTest(){
        System.out.println("I am at After TEST");
    }

    @AfterMethod
    public void doAfterMethod(){
        System.out.println("I am at After Method");
    }

    @AfterClass
    public void doAfterClass(){
        System.out.println("I am at After Class");
    }

    @BeforeGroups("sanity")
    public void doBeforeGroups(){
        System.out.println("I am at Before Groups");
    }

    @AfterGroups("sanity")
    public void doAfterGroups(){
        System.out.println("I am at After Groups");
    }

    @BeforeSuite(groups = "sanity")
    public void doBeforeSuite(){
        System.out.println("I am at Before Suite");
    }

    @AfterSuite (groups = "sanity")
    public void doAfterSuite(){
        System.out.println("I am at After Suite");
    }
}
