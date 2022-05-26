package com.mystore.pageobjects.categories.dresses;

import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Casual_Dresses extends BaseClass {

//    Locators/ WebElements:

    @FindBy(className = "cat-name")
    WebElement casual_dressesText;

    public Casual_Dresses() {
        PageFactory.initElements(driver, this);
    }

    public String validateCasualDress() throws InterruptedException {
        Thread.sleep(1500);
//        wait.until(ExpectedConditions.visibilityOf(evening_dressesText));
        return casual_dressesText.getText();
    }
}
