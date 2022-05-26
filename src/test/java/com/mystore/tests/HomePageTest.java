package com.mystore.tests;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.Home_Page;
import com.mystore.pageobjects.Index_Page;
import com.mystore.pageobjects.Login_Page;
import com.mystore.utility.logClass.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

//    Variables:

    Index_Page indexPage;
    Login_Page loginPage;
    Home_Page homePage;

    @BeforeMethod
    public void setup() {
        launchApp();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void validateTitlePage() {
        Log.startTestCase("Validating wishlist.");
        indexPage = new Index_Page();
        Log.info("User is going to click on the sign-in.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User is entering credentials.");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Log.info("User is landing on the home page. ");
        String actTitlePage = homePage.validateHomePage();
        String expTitlePage = prop.getProperty("titlePage");
        Assert.assertEquals(actTitlePage, expTitlePage);
        Log.endTestCase("User is landing on home page.");
    }

    @Test
    public void verifyNewsletter() {
        Log.startTestCase("Home page test.");
        indexPage = new Index_Page();
        Log.info("User is going to click on the sign-in.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User is entering credentials.");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Log.info("User enters the email in newsletter field.");
        indexPage = homePage.clickOnNewsletter(prop.getProperty("dimagadjilla@gmail.com"));
        Log.info("User is landing on the index page and green message should be show up.");
        String actGreenMessage = indexPage.getGreenValidation();
        String expGreenMessage = prop.getProperty("greenMessage");
        Assert.assertEquals(actGreenMessage, expGreenMessage);
        Log.endTestCase("Test Completed.");
    }
}
