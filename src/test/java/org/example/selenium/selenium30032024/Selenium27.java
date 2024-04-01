package org.example.selenium.selenium30032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium27 {

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
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("macmini");

        //   //*[name()="svg"]
        //  //*[local-name()='svg']

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));

        svgElements.get(0).click();

        Thread.sleep(10000);


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
