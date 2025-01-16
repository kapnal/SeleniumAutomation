package org.example.selenium.selenium24032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {

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
        String URL = "https://money.rediff.com/gainers";
        driver.get(URL);
        driver.manage().window().maximize();

        //List of all Companies
        List<WebElement> allCompanies = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a"));
        System.out.println("Total Number of companies" + " = " + allCompanies.size());

        //List of Current Price
        List<WebElement> currentPrice = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
        System.out.println("Total current Price" + " = " + currentPrice.size());

        String ExpectedResult = "Arigato Universe";

        for (int i = 0; i < allCompanies.size(); i++){
            if(allCompanies.get(i).getText().equalsIgnoreCase(ExpectedResult)){
                System.out.println(allCompanies.get(i).getText() + " == " + currentPrice.get(i).getText());
                allCompanies.get(i).click();
                System.out.println(driver.getTitle());
                break;
            }
        }

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
