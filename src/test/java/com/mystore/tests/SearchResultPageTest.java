package com.mystore.tests;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.Index_Page;
import com.mystore.pageobjects.SearchResult_Page;
import com.mystore.utility.logClass.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {

//    Variables:

    Index_Page indexPage;
    SearchResult_Page searchResultPage;

    @BeforeMethod
    public void setup() {
        launchApp();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void doSearchProduct(){
        Log.startTestCase("Searching a product.");
        indexPage = new Index_Page();
        Log.info("User is entering product name into search field.");
        searchResultPage = indexPage.searchProduct(prop.getProperty("productName"));
        Log.info("User is going to end up on the result page.");
        boolean resultProduct = searchResultPage.validateSearchProduct();
        Assert.assertTrue(resultProduct);
        Log.endTestCase("User is on the result page.");
    }
}
