package org.example.selenium.selenium31032024;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium41 {

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
        try {
        String URL = "https://google.com";
        driver.get(URL);
        driver.manage().window().maximize();

        //StaleElementReferenceException - When we find the element and we refresh so we get StaleElementException
        WebElement ele = driver.findElement(By.xpath("//*[@class=\"gLFyf\"]"));
        driver.navigate().refresh();
        ele.sendKeys("The Testing Academy");

        // Refresh, Navigate other Page, change in DOM elements (Ajax Calls) then it is Stale Element Exception

        //driver.switchTo().frame(1);
        //driver.switchTo().alert().accept();


        Thread.sleep(5000);

        } catch (StaleElementReferenceException | NoSuchElementException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
