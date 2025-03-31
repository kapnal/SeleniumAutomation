package org.example.selenium.selenium17032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium10 {

        @Test(groups = "QA")
        @Description("Verify the current URl, title of VWO app")
        public void testVWOLogin10() {

            WebDriver driver = new ChromeDriver();

            driver.get("https://app.vwo.com/#/login");
            //WebElement anchor_tag = driver.findElement(By.linkText("Start a free trial"));

            WebElement anchor_tag = driver.findElement(By.partialLinkText("Start a free"));


            System.out.println(anchor_tag.getAttribute("href"));
            anchor_tag.click();

           driver.quit();


        }

}
