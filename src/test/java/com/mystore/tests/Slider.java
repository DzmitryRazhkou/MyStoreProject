package com.mystore.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Slider {

    @Test
    public void r() throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");

//        driver.findElement(By.xpath("//*[@id='id_contact']")).click();
//        List<WebElement> list = driver.findElements(By.xpath("//*[@id='id_contact']//option"));

        WebElement sliderAll = driver.findElement(By.id("ul_layered_price_0"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView()", sliderAll);
        System.out.println("It's happened");

        WebElement leftSlider = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]"));
        Point point = leftSlider.getLocation();
        int xCord = point.getX();
        int yCord = point.getY();
        System.out.println(xCord+ " " +yCord);

        int width = leftSlider.getSize().width;
        System.out.println(width);

        Thread.sleep(2000);

        Actions act = new Actions(driver);

//        act.clickAndHold(leftSlider);
//        act.moveByOffset(31, 0).build().perform();

        act.dragAndDropBy(leftSlider, 30 ,0).build().perform();

        Thread.sleep(2000);
        driver.close();



        }
    }

