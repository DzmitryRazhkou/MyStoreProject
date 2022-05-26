package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerService_ContactUsPage extends BaseClass {

    @FindBy(xpath = "//*[@class='alert alert-success']")
    WebElement confirmation_CustomerService;

    public CustomerService_ContactUsPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateGreenMessage(){
        wait.until(ExpectedConditions.visibilityOf(confirmation_CustomerService));
        String green_window = confirmation_CustomerService.getText();
        return green_window;
    }
}
