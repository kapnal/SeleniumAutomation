package org.example.selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium09 {

    @Test(groups = "QA")
    @Description("Verify the current URl, title of VWO app")
    public void testVWOLogin(){

        WebDriver driver = new EdgeDriver();

        // 1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)

        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        // 2. **Find the Email id** and enter the email as admin@admin.com
        //  id, className, name, css Selector, xpath

       WebElement emailInputBox = driver.findElement(By.id("login-username"));
       emailInputBox.sendKeys("admin@admin.com");

       WebElement passwordInputBox = driver.findElement(By.name("password"));
       passwordInputBox.sendKeys("admin");

       driver.findElement(By.id("js-login-btn")).click();

       //After click on login button,we given 3000 ms (3 sec jvm waiting stopeed the driver) wait time to get the error message
       //This is not good practice in future we will do this by using selenium wait
        //Below is checked exception we need to add try catch block

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_text = error_msg.getText();

        //.getAttribute if we want to get value of key   data-qa="rixawilomi"

        String error_msg_attribute_dataqa = error_msg.getAttribute("data-qa");
        System.out.println(error_msg_attribute_dataqa);

        Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");

        driver.quit();



    }
}
