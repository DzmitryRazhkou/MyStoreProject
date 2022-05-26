package com.mystore.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Y {

    @Test
    public void r() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new SafariDriver();

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=contact");

        driver.findElement(By.xpath("//*[@id='id_contact']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//*[@id='id_contact']//option"));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains("Customer service")) {
                list.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@name='id_order']")).click();
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@name='id_order']//option"));

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).getText());
            System.out.println("___________");
            if (list1.get(i).getText().contains("411223")) {
                list1.get(i).click();
                break;
            }

            Thread.sleep(3000);

            driver.close();

        }
    }}

