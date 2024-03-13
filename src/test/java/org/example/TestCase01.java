package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestCase01 {

    public static void main(String[] args) {

        //Microsoft Edge  BeforeSelenium 4.0 version we used system.set property to use driver

        System.setProperty("webdriver.edge.driver", "D:\\Automationjava/geckodriver.exe");
        WebDriver driver = new EdgeDriver();


        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();

    }
}
