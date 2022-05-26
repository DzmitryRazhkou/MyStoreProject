package com.mystore.tests;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import com.mystore.utility.logClass.Log;
import com.mystore.utility.xlsxReader.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class ContactUsPageTest extends BaseClass {

    //    Variables:

    Index_Page indexPage;
    Login_Page loginPage;
    Home_Page homePage;
    ContactUs_Page contactUsPage;
    CustomerService_ContactUsPage customerService_contactUsPage;

    @BeforeMethod
    public void setup() {
        launchApp();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(enabled = false)
    public void verifyContactUsPage() {
        Log.startTestCase("Verifying a customer service page.");
        Log.info("User is landing on the index page.");
        indexPage = new Index_Page();
        Log.info("User is clicking on the sign in button.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User is entering credentials.");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Log.info("User is landing on the contact-Us page.");
        contactUsPage = homePage.clickOnContactUsButton();
        boolean contactUs_ele = contactUsPage.validateContactUsPage();
        Assert.assertTrue(contactUs_ele);
        Log.endTestCase("Web-element showed up.");
    }

    @DataProvider
    public Iterator<Object[]> getData() {
        ArrayList<Object[]> testData = TestUtil.getDataFromExcel_ContactUs();
        return testData.iterator();
    }

    @Test(dataProvider = "getData")
    public void verifyFillUpCustomerService(String message) throws InterruptedException {
        Log.startTestCase("Verifying a customer service page.");
        Log.info("User is landing on the index page.");
        indexPage = new Index_Page();
        Log.info("User is clicking on the sign in button.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User is entering credentials.");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Log.info("User is landing on the contact-Us page.");
        contactUsPage = homePage.clickOnContactUsButton();
        Log.info("Customer is entering the data.");
        customerService_contactUsPage = contactUsPage.fillUpRequest(message);
        Log.info("User is landing on the customer service validation page.");
        String validation_GreenMessage = customerService_contactUsPage.validateGreenMessage();
        Assert.assertEquals(validation_GreenMessage, "Your message has been successfully sent to our team.");
        Log.endTestCase("Test is done");
    }
}
