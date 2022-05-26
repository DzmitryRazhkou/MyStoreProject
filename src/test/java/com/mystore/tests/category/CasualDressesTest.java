package com.mystore.tests.category;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import com.mystore.pageobjects.categories.dresses.Casual_Dresses;
import com.mystore.pageobjects.categories.dresses.Evening_Dresses;
import com.mystore.utility.logClass.Log;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CasualDressesTest extends BaseClass {

    //    Variables:

    Index_Page indexPage;
    Login_Page loginPage;
    Home_Page homePage;
    Casual_Dresses casualDresses;

    @BeforeMethod
    public void setup() {
        launchApp();
    }

    @AfterMethod
    public void tearDown() {
        try {
            driver.quit();
        } catch (NoSuchSessionException crash) {
            crash.printStackTrace();
        }
    }

    @Test
    public void verifyEveningDressesPage() throws InterruptedException {
        Log.startTestCase("Validating wishlist.");
        indexPage = new Index_Page();
        Log.info("User is going to click on the sign-in.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User is entering credentials and landing on the home page.");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Log.info("User is clicking on the return home button and winding up on the index page.");
        indexPage = homePage.goToReturnToHome();
        indexPage.clickOnWomen_icon();
        indexPage.clickOnDress();
        casualDresses = indexPage.clickOnCasualDress();
        String actualText = casualDresses.validateCasualDress();
        String cleaned = actualText.replaceAll("[\\s\\u00A0]+$", "");   // Replace NBSP:
        String expectedText = prop.getProperty("expectedText_cd");
        Assert.assertEquals(cleaned, expectedText);
    }
}

