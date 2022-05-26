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

public class LoginPageTest extends BaseClass {

//    Variables:

    Index_Page indexPage;
    Login_Page loginPage;
    Home_Page homePage;

    @BeforeMethod
    public void setup(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void login() {
        Log.startTestCase("Login test.");
        indexPage = new Index_Page();
        Log.info("User is going to click on the sign-in.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User is entering credentials.");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String actualURL = homePage.getCurrentURL();
        String expectedURL = prop.getProperty("homePageURL");
        Assert.assertEquals(actualURL, expectedURL);
        Log.endTestCase("URLs are matched.");
    }
}
