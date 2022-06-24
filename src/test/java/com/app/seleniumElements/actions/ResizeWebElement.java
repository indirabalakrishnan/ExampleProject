package com.app.seleniumElements.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

/*
Action need build and perform.
Actions perform will do build itself.
 */

public class ResizeWebElement {
    WebDriver driver;
    WebElement source;
    Actions actions;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/resizable/");
        driver.switchTo().frame(0);
        source = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
        actions = new Actions(driver);
    }

    @Test
    public void dragAndDropTest(){
        actions.clickAndHold(source).moveByOffset(100,100).perform();
    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}

