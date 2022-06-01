package com.app.parallelTests;

import org.testng.annotations.Test;

public class ParallelTestClass1 extends BaseTest{
    @Test
    public void testParallelMethod1(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle() + " Method 1");
    }

    @Test
    public void testParallelMethod2(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle()+ " Method 2");
    }

    @Test
    public void testParallelMethod3(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle() + " Method 3");
    }

    @Test
    public void testParallelMethod4(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle() + " Method 4");
    }

    @Test
    public void testParallelMethod5(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle() + " Method 5");
    }

    @Test
    public void testParallelMethod6(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle()+ " Method 6");
    }

    @Test
    public void testParallelMethod7(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle()+ " Method 7");
    }

    @Test
    public void testParallelMethod8(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle()+ " Method 8");
    }

    @Test
    public void testParallelMethod9(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle() + " Method 9");
    }

    @Test
    public void testParallelMethod10(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle() + " Method 10");
    }

    @Test
    public void testParallelMethod11(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle() + " Method 11");
    }

    @Test
    public void testParallelMethod12(){
        getDriver().get("https://www.google.com/");
        System.out.println(Thread.currentThread().getId());
        System.out.println(getDriver().getTitle() + " Method 12");
    }


}
