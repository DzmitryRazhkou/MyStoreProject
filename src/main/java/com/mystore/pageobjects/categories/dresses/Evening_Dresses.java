package com.mystore.pageobjects.categories.dresses;

import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Evening_Dresses extends BaseClass {

//    Locators/ WebElements:

    @FindBy(className = "cat-name")
    WebElement evening_dressesText;

    WebElement logo = driver.findElement(By.xpath("//img[@title='Printed Dress']"));

    public Evening_Dresses(){
        PageFactory.initElements(driver, this);
    }

    public String validateEveningDress() throws InterruptedException {
        Thread.sleep(1500);
//        wait.until(ExpectedConditions.visibilityOf(evening_dressesText));
         return evening_dressesText.getText();
    }
}
