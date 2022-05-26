package com.mystore.pageobjects.categories.dresses;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Summer_Dresses extends BaseClass {

    //    Locators/ WebElements:

    @FindBy(className = "cat-name")
    WebElement summer_dressesText;

    public Summer_Dresses() {
        PageFactory.initElements(driver, this);
    }

    public String validateSummerDress() throws InterruptedException {
        Thread.sleep(1500);
//        wait.until(ExpectedConditions.visibilityOf(evening_dressesText));
        return summer_dressesText.getText();
    }
}
