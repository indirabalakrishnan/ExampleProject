package com.app.seleniumElements.pageElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class radio {
    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        Duration duration = Duration.ofSeconds(10);
        driver.manage().timeouts().implicitlyWait(duration);
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
    }

    @Test
    public void radioButtonTest(){
        driver.findElement(By.id("impressiveRadio")).click();
        Assert.assertEquals("You have selected "+ driver.findElement(By.className("text-success")).getText(),"You have selected Impressive");
    }

    @AfterTest
    public void tearDown(){

    }
}
