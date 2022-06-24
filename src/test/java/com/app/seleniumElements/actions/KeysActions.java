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

public class KeysActions {
    WebDriver driver;
    WebElement textBox;
    Actions actions;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        textBox = driver.findElement(By.name("q"));
        actions = new Actions(driver);
    }

    @Test
    public void pressShiftKeyUsingAction(){
        actions.keyDown(textBox, Keys.SHIFT);
        actions.sendKeys("all small entered");
        actions.keyUp(textBox, Keys.SHIFT);
        Action action = actions.build();
        action.perform();
    }

    @Test
    public void pressShiftKeyUsingActions(){
        actions.keyDown(textBox, Keys.SHIFT);
        actions.sendKeys("all small entered");
        actions.keyUp(textBox, Keys.SHIFT);
        actions.perform();
    }

    @Test
    public void multipleActionsInSingleCommand(){
        actions.keyDown(textBox, Keys.SHIFT).sendKeys("indira balakrishnan").keyUp(Keys.SHIFT).perform();
    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}

