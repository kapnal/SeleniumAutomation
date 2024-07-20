package org.example.selenium.selenium17032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MakeAppt {

    @Test
    @Description("Verify the user logged in successfully")
    public void testLogin() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement makeappt_btn = driver.findElement(By.id("btn-make-appointment"));
        makeappt_btn.click();

        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement username_element= driver.findElement(By.id("txt-username"));
        username_element.sendKeys("John Doe");

        WebElement password_element= driver.findElement(By.xpath("//input[@type=\"password\"]"));
        password_element.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        Thread.sleep(3000);

        driver.quit();






    }
}
