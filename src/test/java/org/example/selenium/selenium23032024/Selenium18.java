package org.example.selenium.selenium23032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium18 {

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));
        WebElement loggedin_username = driver.findElement(By.cssSelector("[data-qa='lufexuloga']"));

        System.out.println("Logged in User details -> " + loggedin_username.getText());

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
