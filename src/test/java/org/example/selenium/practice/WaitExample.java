package org.example.selenium.practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WaitExample {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description("Verify Add box button working fine")
    public void testWithoutWait_Negative() {

        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement addbox = driver.findElement(By.id("adder"));
        addbox.click();
         try {
             WebElement afterboxclick = driver.findElement(By.id("box0"));
         } catch (Exception e){
             System.out.println(e.getMessage());//NoSuchElementException
         }

    }

    @Test(groups = "QA")
    @Description("Verify Add box button working fine")
    public void testImplicitWait_Positive() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement addbox = driver.findElement(By.id("adder"));
        addbox.click();

        WebElement afterboxclick = driver.findElement(By.id("box0"));
        String boxtext = afterboxclick.getAttribute("class");
        System.out.println(boxtext);
        Assert.assertEquals(boxtext,"redbox");
    }

    @Test(groups = "QA")
    @Description("Verify reveal input button working fine")
    public void testExplicitWait_Positive() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        WebElement revealed = driver.findElement(By.id("revealed"));
        WebElement reveal = driver.findElement(By.id("reveal"));
        reveal.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(revealed));

        revealed.sendKeys("Displayed");
        Assert.assertEquals(revealed.getDomProperty("value"),"Displayed");
    }

    @Test(groups = "QA")
    @Description("Verify Add box button working fine")
    public void testFluentWait_Positive() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        WebElement revealed = driver.findElement(By.id("revealed"));
        WebElement reveal = driver.findElement(By.id("reveal"));
        reveal.click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

       wait.until(driver -> {revealed.sendKeys("Displayed");
           return  true;});

        Assert.assertEquals(revealed.getDomProperty("value"),"Displayed");
    }

@AfterTest
    public void closeBrowser(){

        driver.quit();
}

}
