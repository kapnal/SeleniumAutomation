package org.example.selenium.practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab001 {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){

        driver = new EdgeDriver();

    }

    @Test(groups = "QA")
    @Description("Verify the VWO login error when enter invalid username and password")
    public void testVWOLogin_Negative() {

        driver.get("https://app.vwo.com ");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");

        driver.findElement(By.id("js-login-btn")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text = error_msg.getText();
        System.out.println(error_msg_text);
        Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");

    }

    @Test(groups = "QA")
    @Description("Verify the VWO login with valid user name and pass dshboard is display")
    public void testVWOLogin_Positive() {

        driver.get("https://app.vwo.com ");
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("kapilnalwar@gmail.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("St@tion@1234");

        driver.findElement(By.id("js-login-btn")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement user = driver.findElement(By.xpath("//span[@data-qa=\"lufexuloga\"]"));
        String loggedinUser = user.getText();
        System.out.println(loggedinUser);
        Assert.assertEquals(loggedinUser,"kap nal");

    }

@AfterTest
    public void closeBrowser(){

        driver.quit();
}

}
