package com.app.seleniumElements.pageElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class links {
    public WebDriver driver;
    List<WebElement> brokenLinks;
    HttpURLConnection httpURLConnection = null;
    String url = null;

    @BeforeTest
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        Duration duration = Duration.ofSeconds(10);
        driver.manage().timeouts().implicitlyWait(duration);
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();
    }

    public List<WebElement> getAllLinks(){
        List<WebElement> webElements = driver.findElements(By.tagName("a"));
        return webElements;
    }

    public List<WebElement> getBrokenLinks(List<WebElement> webElements) throws IOException {
        Iterator<WebElement> iterator = webElements.listIterator();
        try {
            while (iterator.hasNext()) {
                url = iterator.next().getAttribute("a");
                httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
                if (httpURLConnection.getResponseCode() >= 400){
                    brokenLinks.add(iterator.next());
                }
            }
        }catch (MalformedURLException e){
            e.getMessage();
        }
        return brokenLinks;
    }

    @Test
    public void brokenLinksTest() throws IOException {
        List<WebElement> webElements = getBrokenLinks(getAllLinks());
        Iterator<WebElement> iterator = webElements.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getAttribute("a"));
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
