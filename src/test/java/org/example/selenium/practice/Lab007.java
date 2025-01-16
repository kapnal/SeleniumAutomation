package org.example.selenium.practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab007 {

    @Test
    @Description("Verify the user logged in successfully")
    public void testLogin(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //WebElement btn_element = driver.findElement(By.id("btn-make-appointment"));
        WebElement btn_element = driver.findElement(By.partialLinkText("Make"));
        //WebElement btn_element = driver.findElement(By.linkText("Make Appointment"));
        //WebElement btn_element = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        //WebElement btn_element = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
        btn_element.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement username_element = driver.findElement(By.id("txt-username"));
        username_element.sendKeys("John Doe");

        WebElement password_element = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password_element.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
