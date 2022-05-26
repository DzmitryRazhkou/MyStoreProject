package com.mystore.tests;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCart_Page;
import com.mystore.pageobjects.Index_Page;
import com.mystore.pageobjects.Order_Page;
import com.mystore.pageobjects.SearchResult_Page;
import com.mystore.utility.logClass.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {

    //    Variables:

    Index_Page indexPage;
    SearchResult_Page searchResultPage;
    AddToCart_Page addToCartPage;
    Order_Page orderPage;

    @BeforeMethod
    public void setup() {
        launchApp();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyTotalPrice() {
        Log.startTestCase("Final price test.");
        indexPage = new Index_Page();
        Log.info("User is entering product name into search field.");
        searchResultPage = indexPage.searchProduct(prop.getProperty("productName"));
        Log.info("User willing to click on the product pic.");
        addToCartPage = searchResultPage.clickOnProduct();
        Log.warn("User is setting quantity up.");
        addToCartPage.enterQuantity(prop.getProperty("quantity"));
        Log.warn("User is choosing a size.");
        addToCartPage.selectSize(prop.getProperty("size"));
        Log.info("User is clicking on the proceed to check out.");
        addToCartPage.clickOnAddToCart();
        Log.info("User is landing on the order page.");
        orderPage = addToCartPage.clickOnProceedToCheckout();
        double unitPrice = orderPage.getUnitPrice();
        double totalPrice = orderPage.getTotalPrice();
        double expectedTotalPrice = (unitPrice*3)+2;
        Assert.assertEquals(totalPrice, expectedTotalPrice);
        Log.endTestCase("Prices are matched.");

    }
}
