package org.example.selenium.selenium17032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium13 {

    @Test(groups = "QA")
    @Description("Verify the current URl, title of Katalon app")
    public void testVWOLogin13() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement btnElement_ID = driver.findElement(By.id("btn-make-appointment"));   //If id is vailable preference is to id only

        btnElement_ID.click();
        //wait for 2 min
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement username_element = driver.findElement(By.id("txt-username"));
        username_element.sendKeys("John Doe");

        WebElement password_element = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password_element.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        Thread.sleep(3000);

        driver.quit();


    }
}
