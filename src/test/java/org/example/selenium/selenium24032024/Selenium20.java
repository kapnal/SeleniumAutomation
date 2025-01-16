package org.example.selenium.selenium24032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium20 {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        WebElement element_select = driver.findElement(By.id("dropdown"));
        WebElement element_1 = driver.findElement(By.xpath("//select[@id=\"dropdown\"]/option[@value=\"1\"] "));
        WebElement element_2 = driver.findElement(By.xpath("//select[@id=\"dropdown\"]/option[@value=\"2\"] "));
        Select select = new Select(element_select);
        //select.selectByIndex(0);  //Disabled Please select an option
        //select.selectByIndex(1);
        //select.selectByIndex(2);
        select.selectByVisibleText("Option 2");
        System.out.println(element_2.getText());
       boolean isselect = element_2.isSelected();
        System.out.println(isselect);
        Thread.sleep(5000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
