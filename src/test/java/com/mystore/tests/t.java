package com.mystore.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class t {

    @Test
    public void r() throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("dimagadjilla@gmail.comemhfhf");
        driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("days")));
//        Thread.sleep(2000);
        WebElement f = driver.findElement(By.id("years"));

        f.click();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()", f);

        List<WebElement> list = driver.findElements(By.xpath("(//*[@class='form-control'])[3]//option"));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains("1990")) {
                list.get(i).click();
                break;
            }
        }
    }
}

