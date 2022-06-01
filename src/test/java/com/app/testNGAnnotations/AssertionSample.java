package com.app.testNGAnnotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionSample {
    @Test(priority = 1)
    public void assertionTest1(){
        System.out.println("assertionTest1");
        Assert.assertEquals(1,1);
        Assert.assertEquals(1,2,"Actual and Expected are not equal");
        Assert.assertTrue(1==1);
        Assert.assertTrue(1==2, "Assert Condition fails");
//

//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(1,1);
//        softAssert.assertEquals(1,2,"Actual and Expected are not equal");
//        softAssert.assertTrue(1==1);
//        softAssert.assertTrue(1==2, "Assert Condition fails");
    }
}
