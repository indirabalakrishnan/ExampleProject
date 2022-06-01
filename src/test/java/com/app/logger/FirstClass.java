package com.app.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstClass {
    Logger logger = LogManager.getLogger(FirstClass.class);
    @Test
    public void sampleTest1(){
        logger.info("Info printed");
        Assert.assertEquals(true, true);
    }

    @Test
    public void sampleTest2(){
        Assert.assertEquals(true, true);
    }
}
