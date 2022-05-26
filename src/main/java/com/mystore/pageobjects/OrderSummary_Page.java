package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSummary_Page extends BaseClass {

    @FindBy (xpath = "//*[contains(text(),'I confirm my order')]")
    WebElement confirm_WirePay;

    public OrderSummary_Page(){
        PageFactory.initElements(driver, this);
    }

    public OrderConfirmation_Page clickOnConfirm(){
        wait.until(ExpectedConditions.visibilityOf(confirm_WirePay));
        Action_Driver_Perform.click(driver, confirm_WirePay);
        return new OrderConfirmation_Page();
    }
}
