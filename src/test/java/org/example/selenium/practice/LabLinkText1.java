package org.example.selenium.practice;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class LabLinkText1 {

    @Test
    @Description("Verify VWO Login Failed, when we enter invalid username and password")
    public void vwoLogin() {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

        // Find all the a tag and print the text

        List<WebElement> all_tags = driver.findElements(By.tagName("a"));
 //       all_tags.get(1).click(); // start free trial
//        all_atags.get(1).click(); // 2nd one - vwo insights
        System.out.println(all_tags.size()); // 2
        for (WebElement element: all_tags){
            System.out.println(element.getText());
        }

        driver.quit();
    }
}
