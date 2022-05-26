package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Address_Page extends BaseClass {

    @FindBy (xpath = "(//*[contains(text(),'Proceed to checkout')])[2]")
    WebElement proceedToCheckoutAddressPage;

    public Address_Page(){
        PageFactory.initElements(driver, this);
    }

    public Shipping_Page clickProceedBtn(){
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutAddressPage));
        Action_Driver_Perform.click(driver, proceedToCheckoutAddressPage);
        return new Shipping_Page();
    }
}
