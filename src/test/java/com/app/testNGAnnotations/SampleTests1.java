package com.app.testNGAnnotations;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTests1 extends BaseTest2 {

    @Test(priority = 1, description = "Test Method 1 Description", groups = {"raje"})
    public void testMethod1(){
        extentTest = extentReportManager.extentReports.createTest("testMethod1");
        extentTest.info("testMethod1 --> Info Printed");
        Assert.assertTrue(true);
    }

    @Test(priority = 2, description = "Test Method 2 Description", groups = {"raje"})
    public void testMethod2(){
        extentTest = extentReportManager.extentReports.createTest("testMethod2");
        extentTest.info("testMethod2 --> Info Printed");
        Assert.assertTrue(true);
    }

    @Test(priority = 1, description = "Test Method 3 Description", enabled = false, groups = {"jaya"})
    public void testMethod3(){
        extentTest = extentReportManager.extentReports.createTest("testMethod3");
        extentTest.info("testMethod3 --> Info Printed");
        Assert.assertTrue(true);
    }

    @Test(priority = 3, description = "Test Method 4 Description", dependsOnMethods = {"testMethod2"}, groups = {"jaya"})
    public void testMethod4(){
        extentTest = extentReportManager.extentReports.createTest("testMethod4");
        extentTest.info("testMethod4 --> Info Printed");
        Assert.assertTrue(true);
    }

    @Test(priority = 1, description = "Test Method 5 Description", enabled = true, groups = {"indu"})
    public void testMethod5(){
        extentTest = extentReportManager.extentReports.createTest("testMethod5");
        extentTest.info("testMethod5 --> Info Printed");
        Assert.assertTrue(true);
    }

    @Test(priority = 1, description = "Test Method 6 Description", enabled = true, groups = {"indu"})
    public void testMethod6(){
        extentTest = extentReportManager.extentReports.createTest("testMethod6");
        extentTest.info("testMethod6 --> Info Printed");
        Assert.assertTrue(true);
    }

    @Test(priority = 1, description = "Test Method 7 Description", enabled = true, groups = {"raje", "indu"})
    public void testMethod7(){
        extentTest = extentReportManager.extentReports.createTest("testMethod7");
        extentTest.info("testMethod7 --> Info Printed");
        Assert.assertTrue(false);
    }

    @Test(priority = 1, description = "Test Method 8 Description", enabled = true, groups = {"raje", "indu"})
    @Parameters({"Apple", "Orange"})
    public void testMethod8(String a, String b){
        extentTest = extentReportManager.extentReports.createTest("testMethod8");
        extentTest.info(a);
        extentTest.info(b);
        extentTest.info("testMethod8 --> Info Printed");
        Assert.assertTrue(true);
    }
}
