package com.app.testNGAnnotations;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider
    public Object[][] data3(){
        return new Object[][]{{"Subash"}, {"Rohit"}};
    }
}
