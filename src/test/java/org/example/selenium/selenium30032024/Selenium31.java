package org.example.selenium.selenium30032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class Selenium31 {

    ChromeDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        // THETESTINGACADEMY
        // Shift Keydown -> thtestingacademy + Shift KeyUp

        WebElement firstName = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);

        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(firstName,"thetestingacademy")
                .keyUp(Keys.SHIFT).build().perform();

        //Click on the Click here to Download File link

        WebElement link = driver.findElement(By.xpath("//a[text()='Click here to Download File']"));
        actions.contextClick(link).build().perform();

        Thread.sleep(10000);




    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
