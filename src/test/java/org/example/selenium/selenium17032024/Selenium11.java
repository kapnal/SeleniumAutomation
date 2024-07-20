package org.example.selenium.selenium17032024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.util.List;

public class Selenium11 {

    @Test(groups = "QA")
    @Description("Verify the current URl, title of VWO app")
    public void testVWOLogin11() {

        WebDriver driver = new EdgeDriver();
        // 1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
        driver.get("https://app.vwo.com/#/login");
        // Question - Print all the anchor Tags on this vwo.com
        // a tags and print the getText
        List<WebElement> all_atags = driver.findElements(By.tagName("a"));
           //all_atags.get(1).click(); // start free trial
//        all_atags.get(1).click(); // 2nd one - vwo insights
        System.out.println(all_atags.size()); // 2


        for( WebElement element: all_atags){
            System.out.println(element.getText());
        }




        driver.quit(); // Close the current window

    }
}
