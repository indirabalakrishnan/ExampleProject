package com.app.seleniumElements.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Action need build and perform.
Actions perform will do build itself.
 */

public class MouseHover {
    WebDriver driver;
    WebElement source;
    WebElement target;
    Actions actions;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        source = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions = new Actions(driver);
    }

    @Test
    public void dragAndDropTest(){
        actions.moveToElement(source).perform();
        System.out.println(source.getText());
    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}

