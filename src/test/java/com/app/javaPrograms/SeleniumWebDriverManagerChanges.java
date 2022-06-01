package com.app.javaPrograms;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumWebDriverManagerChanges {
    @Test
    public void oldBehavior(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        WebDriverManager.chromedriver().setup(); //WebDriverManager old version behavior 4.x version
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://www.google.com");
        System.out.println(webDriver.getCurrentUrl());
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.google.com/");
    }

    @Test
    public void newBehavior(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create(); //new WebdriverManager behavior 5.x version.
        webDriver.get("https://www.google.com");
        System.out.println(webDriver.getCurrentUrl());
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.google.com/");
    }
}
