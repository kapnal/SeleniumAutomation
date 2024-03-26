package org.example.selenium.selenium23032024;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium19 {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() {
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Global wait to all the elements which we don't use

        driver.findElement(By.id("login-username")).sendKeys("kapilnalwar@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("St@tion@1234");
        driver.findElement(By.id("js-login-btn")).click();

        Wait<EdgeDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement loggedin_username = wait.until(driver -> driver.findElement(By.cssSelector("[data-qa='lufexuloga']")));

        System.out.println("Logged in User details -> " + loggedin_username.getText());

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
