package org.example.selenium.selenium24032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable1 {

    ChromeDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);
        driver.manage().window().maximize();

        //List of all Companies
        List<WebElement> allContacts = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr/td[2]"));
        System.out.println("Total Number of contact" + " = " + allContacts.size());

        //List of Current Price
        List<WebElement> country = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr/td[3]"));
        System.out.println("Total country" + " = " + country.size());

        String ExpectedResult = "Helen Bennett";

        for (int i = 0; i < allContacts.size(); i++){
             if (allContacts.get(i).getText().equalsIgnoreCase(ExpectedResult)) {
                 System.out.println(allContacts.get(i).getText() + " = " + country.get(i).getText());
                 break;
             }
        }

        Thread.sleep(5000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
