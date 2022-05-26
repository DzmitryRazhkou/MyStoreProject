package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderConfirmation_Page extends BaseClass {

    @FindBy(xpath = "//*[contains(text(),'Your order on My Store is complete.')]")
    WebElement confirmMessage;

    public OrderConfirmation_Page() {
        PageFactory.initElements(driver, this);
    }

    public String validateConfirmMessage() {
        wait.until(ExpectedConditions.visibilityOf(confirmMessage));
        String message = confirmMessage.getText();
        return message;
    }
}
