package com.app.seleniumElements.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Action need build and perform.
Actions perform will do build itself.
 */

public class SelectAndReorder {
    WebDriver driver;
    WebElement items7, items1;
    Actions actions;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/sortable/");
        driver.switchTo().frame(0);
        items7 = driver.findElement(By.xpath("//ul[@id='sortable']/li[7]"));
        actions = new Actions(driver);
    }

    @Test
    public void sortTest(){
        for (int i=1;i<=6;i++){
            items1 = driver.findElement(By.xpath("//ul[@id='sortable']/li["+i+"]"));
            actions.clickAndHold(items7).moveToElement(items1).release().perform();
        }
    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}

