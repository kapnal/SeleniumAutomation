package org.example.selenium.seleniumMiniproject;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class katalonMakeAppointment {

    ChromeDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify User is logged in to katalon")
    public void testkatalonLogin12() throws InterruptedException {

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

       WebElement btnElement_ID = driver.findElement(By.id("btn-make-appointment"));

        btnElement_ID.click();
        //wait for 2 min

        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement username_element = driver.findElement(By.xpath("//input[@id=\"txt-username\"]"));
        username_element.sendKeys("John Doe");

        WebElement password_element = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password_element.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        Thread.sleep(3000);

        WebElement element_select = driver.findElement(By.id("combo_facility"));
         Select select = new Select(element_select);
         select.selectByIndex(2);

         WebElement checkbox1 = driver.findElement(By.xpath("//input[@id=\"chk_hospotal_readmission\"]"));
         checkbox1.click();

         WebElement radio_select = driver.findElement(By.xpath("//input[@id=\"radio_program_none\"]"));
         radio_select.click();

         WebElement visit_date_inputbox = driver.findElement(By.cssSelector("input[placeholder=\"dd/mm/yyyy\"]"));
         visit_date_inputbox.sendKeys("02/04/2024");

         WebElement comment_inputbox = driver.findElement(By.xpath("//textarea[@id=\"txt_comment\"]"));
         comment_inputbox.sendKeys("Hello please confirm my appointment");

        Thread.sleep(10000);

        driver.findElement(By.id("btn-book-appointment")).click();
        Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()=\"Appointment Confirmation\"]")));

        WebElement appoitnement_confirm_msg = driver.findElement(By.xpath("//h2[text()=\"Appointment Confirmation\"]"));
        System.out.println("Apointment Confirm title -> " + appoitnement_confirm_msg.getText());

        WebElement apt_confirm_text = driver.findElement(By.xpath("//p[text()=\"Please be informed that your appointment has been booked as following:\"]"));
        System.out.println("Apoint Confirmation Message -> " + apt_confirm_text.getText());

        WebElement comment_msg = driver.findElement(By.xpath("//p[@id=\"comment\"]"));
        System.out.println("Comment message is -> " + comment_msg.getText());


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
