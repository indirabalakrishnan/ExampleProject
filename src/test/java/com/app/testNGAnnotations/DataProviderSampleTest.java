package com.app.testNGAnnotations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderSampleTest {
    @DataProvider(name = "data1")
    public Object[][] data1(){
        return new Object[][]{{"Indira"}, {"Jaya"}};
    }

    @DataProvider(name = "data2")
    public Object[][] data3(){
        return new Object[][]{{1,2,3},{4,5,6}};
    }

    @Test(dataProvider = "data1")
    public void testData1(String string){
        System.out.println(string);
    }

    @Test(dataProvider = "data3", dataProviderClass = DataProviderClass.class)
    public void testData2(String string){
        System.out.println(string);
    }

    @Test(dataProvider = "data2")
    public void testData3(int a, int b, int c){
        System.out.println(a+b+c);
    }
}
