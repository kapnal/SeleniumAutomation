package org.example.selenium.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium06 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://sdet.live");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

       //driver.close();  //Close current browser window only - session id !=null it will invalid session id

       driver.quit();  //close all browser window and close browser - session is = null

    }
}
