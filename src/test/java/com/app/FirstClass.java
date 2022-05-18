package com.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstClass {
    @Test
    public void sampleTest1(){
        Assert.assertEquals(true, true);
    }

    @Test
    public void sampleTest2(){
        Assert.assertEquals(false, true);
    }
}
