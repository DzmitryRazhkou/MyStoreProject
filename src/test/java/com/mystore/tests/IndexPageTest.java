package com.mystore.tests;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.Index_Page;
import com.mystore.utility.logClass.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {

//    Variables:

    Index_Page indexPage;

    @BeforeMethod
    public void setup(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyLogo(){
        Log.startTestCase("Verifying a logo.");
        indexPage = new Index_Page();
        Log.info("Logo is showing up on the index page.");
        boolean logo_result = indexPage.validateLogo();
        Assert.assertTrue(logo_result);
        Log.endTestCase("Logo showed up.");
    }

    @Test
    public void verifyPageTitle(){
        Log.startTestCase("Page title test.");
        String expectedTitle = prop.getProperty("pageTitle");
        String actualTitle = indexPage.getMyStoreTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Log.endTestCase("Titles are matched.");
    }
}
