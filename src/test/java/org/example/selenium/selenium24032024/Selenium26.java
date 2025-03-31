package org.example.selenium.selenium24032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class Selenium26 {

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
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);
        driver.manage().window().maximize();

        //table[@summary="Sample Table"]/tbody/tr[1]/td
        //table[@summary="Sample Table"]/tfoot/tr/td

        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        System.out.println(rows_table.size());

        for (int i =0; i < rows_table.size(); i++){
            List<WebElement> col = rows_table.get(i).findElements(By.tagName("td"));

            for (WebElement e: col){
                System.out.println(e.getText());
            }
        }

        Thread.sleep(10000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
