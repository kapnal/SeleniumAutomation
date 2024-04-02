package org.example.selenium.selenium30032024;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium29 {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        driver.manage().window().maximize();
//#shadow-root (open) if any element in between shadow root then xpath  -//input[@id="pizza"]  this will not work
//Go to Console and type Javascript - document and press enter
        //document.querySelector("div#userName")

        //Javascript Code -  document.querySelector("div#userName").shadowRoot.querySelector("div").shadowRoot.querySelector("input#pizza")
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //To reach the elemet we nedd to scroll down
        //document.querySelector("div#userName").shadowRoot.querySelector(".learningHub")


        WebElement divScrollTo  = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);",divScrollTo);

        Thread.sleep(3000);

        WebElement inputboxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
        inputboxPizza.sendKeys("FarmHouse");

        Thread.sleep(13000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
