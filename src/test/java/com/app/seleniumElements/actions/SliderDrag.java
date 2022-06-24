package com.app.seleniumElements.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SliderDrag {
    WebDriver driver;
    WebElement slider;
    WebElement value;
    Actions action;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rangeslider.js.org/");
        slider = driver.findElement(By.xpath("//div[@id='js-rangeslider-0']/div[2]"));
        value = driver.findElement(By.id("js-output"));
        action = new Actions(driver);
    }

    @Test
    public void moveSliderLeft(){
        action.dragAndDropBy(slider, -100, 0).perform();
        System.out.println(value.getText());
    }

    @Test
    public void moveSliderRight(){
        action.dragAndDropBy(slider, 100, 0).perform();
        System.out.println(value.getText());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
