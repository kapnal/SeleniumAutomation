package org.example.selenium.selenium17032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium12 {

    @Test(groups = "QA")
    @Description("Verify the current URl, title of VWO app")
    public void testkatalonLogin12() throws InterruptedException {

        WebDriver driver = new EdgeDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

       WebElement btnElement_ID = driver.findElement(By.id("btn-make-appointment"));   //If id is vailable preference is to id only

        //Different ways to find the wen elements
        //WebElement btnElement_CN = driver.findElement(By.className("btn.btn-dark.btn-lg"));
        //WebElement btnElement_PTEXT = driver.findElement(By.partialLinkText("Make"));
        //WebElement btnElement_LTEXT = driver.findElement(By.linkText("Make Appointment"));
        //WebElement btnElement_AT = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
        //WebElement btnElement_AT = driver.findElement(By.tagName("a")); //Multiple tags so not recommended

        btnElement_ID.click();
        //wait for 2 min

        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        //<input
        // type="text" - NR
        // class="form-control"  Not unique not recommended (NR)
        // id="txt-username" - R (Recommended)
        // name="username" - R
        // placeholder="Username" - NR- 2 elements
        // value=""  - NR
        // autocomplete="off"> - NR

        WebElement username_element = driver.findElement(By.id("txt-username"));
        username_element.sendKeys("John Doe");

        WebElement password_element = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password_element.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        Thread.sleep(3000);

        driver.quit();


    }
}
