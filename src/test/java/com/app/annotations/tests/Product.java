package com.app.annotations.tests;

import com.app.annotations.customAnnotations.Jira;
import com.app.annotations.customAnnotations.Module;
import com.app.annotations.customAnnotations.Risk;
import com.app.annotations.enums.RiskValues;
import org.testng.Assert;
import org.testng.annotations.Test;

@Module(name = "product")
public class Product {
    @Test
    @Risk(value = RiskValues.High)
    @Jira(id = "RR-2")
    public void productTest1(){
        Assert.assertTrue(false);
    }

    @Test
    @Risk(value = RiskValues.High)
    @Jira(id = "RR-3")
    public void productTest2(){
        Assert.assertTrue(true);
    }
}
