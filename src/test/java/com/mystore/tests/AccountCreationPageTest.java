package com.mystore.tests;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreation_Page;
import com.mystore.pageobjects.Index_Page;
import com.mystore.pageobjects.Login_Page;
import com.mystore.utility.logClass.Log;
import com.mystore.utility.xlsxReader.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class AccountCreationPageTest extends BaseClass {

//    Variables:

    Index_Page indexPage;
    Login_Page loginPage;
    AccountCreation_Page accountCreationPage;

    @BeforeMethod
    public void setup() {
        launchApp();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void createAccount() {
        Log.startTestCase("Creating a new account test.");
        indexPage = new Index_Page();
        Log.info("User is going to click on the sign-in.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User is entering a new email.");
        accountCreationPage = loginPage.createNewAccount(prop.getProperty("emailNewAccount"));
        boolean accountResult = accountCreationPage.validateAccountPage();
        Assert.assertTrue(accountResult);
        Log.endTestCase("User is landing on the account creating page.");
    }

    @DataProvider
    public Iterator<Object[]> getData() {
        ArrayList<Object[]> testData = TestUtil.getDataFromExcel_CreateAccount();
        return testData.iterator();
    }

    @Test(dataProvider = "getData")
    public void enterCustomerPersonalInfo(String emailCreateAccount, String firstname, String lastname, String password,
    String days, String months, String years, String address, String address2, String city, String state, String zip, String message, String phone) {
        Log.startTestCase("Filling up a personal info test.");
        indexPage = new Index_Page();
        Log.info("User is going to click on the sign-in.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User is entering a new email.");
        accountCreationPage = loginPage.createNewAccount(emailCreateAccount);
        Log.info("User is filing the page up with personal info.");
        accountCreationPage.enterPersonalInformation(firstname, lastname, password, days, months, years, address, address2, city, state, zip, message, phone);
        Log.endTestCase("Test completed.");
    }
}
