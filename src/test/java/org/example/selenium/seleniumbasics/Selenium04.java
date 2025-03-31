package org.example.selenium.seleniumbasics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.WebDriver;


public class  Selenium04 {
    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        //edgeOptions.addArguments("--headless");
        //edgeOptions.addArguments("--incognito");
        //edgeOptions.addArguments("--window-size=800,600");
        WebDriver driver = new ChromeDriver(chromeOptions); // Dynamic Dispatch -> Runtime Poly
        driver.get ("https://sdet.live");
        System.out.println(driver.getTitle());

        //driver.manage().window().maximize();

        driver.quit();



    }

}
