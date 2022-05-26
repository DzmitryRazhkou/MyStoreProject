package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Payment_Page extends BaseClass {

    @FindBy (xpath = "//a[@title='Pay by bank wire']")
    WebElement payByBankWire;

    @FindBy (xpath = "//a[@title='Pay by check.']")
    WebElement payByCheck;

    public Payment_Page(){
        PageFactory.initElements(driver, this);
    }

    public OrderSummary_Page clickOnPayByWire(){
        wait.until(ExpectedConditions.visibilityOf(payByBankWire));
        Action_Driver_Perform.click(driver, payByBankWire);
        return new OrderSummary_Page();
    }


}
