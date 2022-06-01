package com.app.testNGAnnotations;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGSampleTest1 extends BaseTest {
    @Test(groups = {"sanity"}, enabled=true)
    @Parameters({"name1", "name2"})
    public void test1(String name1, String name2){
        System.out.println("I am  at TEST");
        System.out.println(name1 + " " + name2);
        Assert.assertEquals(1,1);
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("I am  at TEST2");
        Assert.assertEquals(1,1);
    }
}
