package org.example.selenium.practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OrangeHRM {

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
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"password\"]")));

        WebElement user_element = driver.findElement(By.xpath("//input[@name=\"username\"]"));
                user_element.sendKeys("Admin");

        WebElement password_element = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password_element.sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()=\"Dashboard\"]")));
        WebElement text_msg = driver.findElement(By.xpath("//h6[text()=\"Dashboard\"]"));
        System.out.println("Text -> " + text_msg.getText());
        Assert.assertEquals(text_msg.getText(),"Dashboard");



    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
