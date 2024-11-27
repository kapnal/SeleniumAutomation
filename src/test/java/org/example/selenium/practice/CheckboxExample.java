package org.example.selenium.practice;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxExample {

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
    public void testCheckbox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
               WebElement ch = checkboxes.get(0);
               ch.click();

        System.out.println( ch.isSelected());

    }

    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }
}
