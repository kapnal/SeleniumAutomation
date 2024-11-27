package org.example.selenium.practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionsExample {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description("Verify user Select dropdown value and it's value ")
    public void testAction() {

        driver.get("https://www.makemytrip.com/");

        WebElement fromcity = driver.findElement(By.xpath("//input[@id='fromCity']"));
        Actions action = new Actions(driver);
        action.moveToElement(fromcity).click().sendKeys("PUNE").build().perform();

    }

    @Test(groups = "QA")
    @Description("Verify user Select dropdown value and it's value ")
    public void testSelectbyIndex() {

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        WebElement locate_country = driver.findElement(By.name("country"));
        Select country_select = new Select(locate_country);
        country_select.selectByIndex(12);
        WebElement option = country_select.getFirstSelectedOption();
        String SelectedText = option.getText();
        System.out.println(SelectedText);
        Assert.assertEquals(SelectedText,"AUSTRALIA");

    }
@AfterTest
    public void closeBrowser(){

        driver.quit();
}

}
