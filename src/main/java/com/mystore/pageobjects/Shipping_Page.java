package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Shipping_Page extends BaseClass {

    @FindBy(id = "uniform-cgv")
    WebElement terms;

    @FindBy(name = "processCarrier")
    WebElement proceedBtnShipping_Page;

    public Shipping_Page() {
        PageFactory.initElements(driver, this);
    }

    public void clickTerms() {
        wait.until(ExpectedConditions.visibilityOf(terms));
        Action_Driver_Perform.click(driver, terms);
    }

    public Payment_Page clickProceedBtn() {
        wait.until(ExpectedConditions.visibilityOf(proceedBtnShipping_Page));
        Action_Driver_Perform.click(driver, proceedBtnShipping_Page);
        return new Payment_Page();
    }
}
