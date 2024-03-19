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

        driver.get("https://app.vwo.com/#/login");

        //Print all the anchor tags  a tags and getText

        List<WebElement> all_tags = driver.findElements(By.tagName("a") );

        all_tags.get(0).click();  // It will click oStart free trial
        all_tags.get(1).click(); // It will click  Read more about
        all_tags.size();

        for(WebElement element:all_tags){

            System.out.println(element.getText());
        }

        driver.quit();

    }
}
