package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Order_Page extends BaseClass {

    @FindBy(xpath = "//span[contains(text(),'$16.51')]")
    WebElement priceUnit;

    @FindBy(id = "total_price")
    WebElement totalPrice;

    @FindBy(xpath = "(//*[@title='Proceed to checkout'])[2]")
    WebElement proceedToCheckOut_2;

    public Order_Page() {
        PageFactory.initElements(driver, this);
    }

    public double getUnitPrice() {
        wait.until(ExpectedConditions.visibilityOf(priceUnit));
        String price = priceUnit.getText();
        String price_tr = price.replaceAll("[^a-zA-Z0-9]", "");
        double finalPrice = Double.parseDouble(price_tr);
        return finalPrice / 100;
    }

    public double getTotalPrice() {
        wait.until(ExpectedConditions.visibilityOf(totalPrice));
        String total_Price = totalPrice.getText();
        String totalPrice_tr = total_Price.replaceAll("[^a-zA-Z0-9]", "");
        double finalTotalPrice = Double.parseDouble(totalPrice_tr);
        return finalTotalPrice / 100;

    }

    public Address_Page clickProceed() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut_2));
        Action_Driver_Perform.click(driver, proceedToCheckOut_2);
        return new Address_Page();
    }

    public Login_Page clickProceedToLogin() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut_2));
        Action_Driver_Perform.click(driver, proceedToCheckOut_2);
        return new Login_Page();
    }
}
