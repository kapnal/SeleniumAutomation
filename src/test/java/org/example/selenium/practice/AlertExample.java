package org.example.selenium.practice;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description("Verify the js alert text")
    public void testJsAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement js_alert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        js_alert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
        System.out.println(result);
        Assert.assertEquals(result,"You successfully clicked an alert");
    }

    @Test(groups = "QA")
    @Description("Verify the js confirm text")
    public void testJsConfirm() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement js_confirm = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        js_confirm.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
        System.out.println(result);
        Assert.assertEquals(result,"You clicked: Ok");
    }

    @Test(groups = "QA")
    @Description("Verify the js confirm text")
    public void testJsPrompt() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement js_prompt = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        js_prompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hi THis is Kapil");
        alert.accept();
        //alert.dismiss();

        String result = driver.findElement(By.id("result")).getText();
        System.out.println(result);
        Assert.assertEquals(result,"You entered: Hi THis is Kapil");
        //Assert.assertEquals(result,"You entered: null");
    }

    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }
}
