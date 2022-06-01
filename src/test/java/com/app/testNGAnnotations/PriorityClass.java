package com.app.testNGAnnotations;

import org.testng.annotations.Test;

public class PriorityClass {
    @Test(priority = 1, description = "This Test is about the priority test1")
    public void priorityTest1(){
        System.out.println("priorityTest1");
    }

    @Test(priority = 2, invocationCount = 3, invocationTimeOut = 1)
    public void priorityTest2(){
        System.out.println("priorityTest2");
    }

    @Test(priority = 3)
    public void priorityTest3(){
        System.out.println("priorityTest3");
    }

    @Test(priority = 1)
    public void priorityTest4(){
        System.out.println("priorityTest4");
    }

    @Test(priority = 2)
    public void priorityTest5(){
        System.out.println("priorityTest5");
    }

    @Test(priority = 3)
    public void priorityTest6(){
        System.out.println("priorityTest6");
    }
}
