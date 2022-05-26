package com.mystore.tests;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class EndToEndTest extends BaseClass {

    //    Variables:

    Index_Page indexPage;
    Login_Page loginPage;
    SearchResult_Page searchResultPage;
    AddToCart_Page addToCartPage;
    Order_Page orderPage;
    Address_Page addressPage;
    Shipping_Page shippingPage;
    Payment_Page paymentPage;
    OrderSummary_Page orderSummaryPage;
    OrderConfirmation_Page confirmationPage;

    @BeforeMethod
    public void setup() {
        launchApp();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void endToEnd() {
        indexPage = new Index_Page();
        searchResultPage = indexPage.searchProduct(prop.getProperty("productName"));
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(prop.getProperty("quantity"));
        addToCartPage.selectSize(prop.getProperty("size"));
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnProceedToCheckout();
        loginPage = orderPage.clickProceedToLogin();
        addressPage = loginPage.loginBeforeAddress_Page(prop.getProperty("username"), prop.getProperty("password"));
        shippingPage = addressPage.clickProceedBtn();
        shippingPage.clickTerms();
        paymentPage = shippingPage.clickProceedBtn();
        orderSummaryPage = paymentPage.clickOnPayByWire();
        confirmationPage = orderSummaryPage.clickOnConfirm();
        String actualMessage = confirmationPage.validateConfirmMessage();
        String expectedMessage = prop.getProperty("expectedMessage");
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
