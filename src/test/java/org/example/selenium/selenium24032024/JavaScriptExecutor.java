package org.example.selenium.selenium24032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class JavaScriptExecutor {

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
    public void testPositive() throws Exception {
        String URL = "https://www.facebook.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        //JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("document.getElementById('email').value='9689022135'");
        jse.executeScript("document.getElementsByName('pass')[0].value='St@tion@1234'");
        jse.executeScript("document.getElementsByName('login')[0].click()");

        // Scroll Down using JavaScript
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0, 800)");

        // Scroll Up using JavaScript
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0, -800)");



    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
