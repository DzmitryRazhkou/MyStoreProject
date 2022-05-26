package com.mystore.tests;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import com.mystore.utility.logClass.Log;
import com.mystore.utility.xlsxReader.TestUtil;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class AddToCartPageTest extends BaseClass {

    //    Variables:

    Index_Page indexPage;
    Login_Page loginPage;
    Home_Page homePage;
    SearchResult_Page searchResultPage;
    AddToCart_Page addToCartPage;

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

    @Test(enabled = false)
    public void clickOnProduct_AddToCart() {
        Log.startTestCase("Add-to-Cart Test.");
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
        boolean success = addToCartPage.validateAddToCart();
        Assert.assertTrue(success);
        Log.endTestCase("Test completed.");
    }

    @Test(enabled = false)
    public void userAddToWishList() {
        Log.startTestCase("User add to wish list Test.");
        indexPage = new Index_Page();
        Log.info("User is entering product name into search field.");
        searchResultPage = indexPage.searchProduct(prop.getProperty("productName"));
        Log.info("User willing to click on the product pic.");
        addToCartPage = searchResultPage.clickOnProduct();
        Log.warn("User is clicking on the wish list icon.");
        addToCartPage.addToWishlist();
        Log.info("Added to your wishlist element is popping up");
        boolean pop_up = addToCartPage.validateAddElement();
        Assert.assertTrue(pop_up);
        Log.info("User clicks on the cross");
        addToCartPage.closeAddWish();
        Log.endTestCase("Test completed.");
    }

    @Test(enabled = false)
    public void writeReview() {
        Log.startTestCase("Validating writing review of the product.");
        indexPage = new Index_Page();
        Log.info("User is going to click on the sign-in.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User is entering credentials and landing on the home page.");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Log.info("User is clicking on the return home button and landing on the index page.");
        indexPage = homePage.goToReturnToHome();
        Log.info("User clicks on the product picture and go to addToCart page.");
        addToCartPage = indexPage.clickOnProduct();
        Log.info("User clicks on the write review button and fill up required fields and clicks a send button.");
        addToCartPage.createWriteReview(prop.getProperty("dropDownValue"));
        Log.info("The new comment confirm message is appeared.");
        String actualNewComment = addToCartPage.validateNewComment();
        String expectedNewComment = prop.getProperty("newComment");
        Assert.assertEquals(actualNewComment, expectedNewComment);
        Log.endTestCase("Test completed.");
    }



    @DataProvider
    public Iterator<Object[]> getData() {
        ArrayList<Object[]> testData = TestUtil.getDataFromExcel_SendToFriend();
        return testData.iterator();
    }

    @Test(dataProvider = "getData")
    public void sendToFriend(String nameOfFriend, String emailOfFriend) {
        Log.startTestCase("Validating writing review of the product.");
        indexPage = new Index_Page();
        Log.info("User is going to click on the sign-in.");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User is entering credentials and landing on the home page.");
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Log.info("User is clicking on the return home button and landing on the index page.");
        indexPage = homePage.goToReturnToHome();
        Log.info("User clicks on the product picture and go to addToCart page.");
        addToCartPage = indexPage.clickOnProduct();
        Log.info("User clicks on the sent to friend button and fill up required fields and clicks a send button.");
        addToCartPage.doSendToFriend(nameOfFriend, emailOfFriend);
        Log.info("The send to friend confirm message is appeared.");
        String actual_SendToFriendNewMessage = addToCartPage.validateSendToFriend();
        String expected_SendToFriendNewMessage = prop.getProperty("sendToFriend_NewMessage");
        Assert.assertEquals(actual_SendToFriendNewMessage, expected_SendToFriendNewMessage);
        Log.endTestCase("Test completed.");
    }

    @Test(enabled = false)
    public void validateTransferToTwitter() {
        Log.startTestCase("Transfer to Twitter.");
        indexPage = new Index_Page();
        Log.info("User is entering product name into search field.");
        searchResultPage = indexPage.searchProduct(prop.getProperty("productName"));
        Log.info("User willing to click on the product pic.");
        addToCartPage = searchResultPage.clickOnProduct();
        Log.warn("User is clicking and landing on the Twitter page.");
        String expectedTitlePageTwitter = addToCartPage.doTransferTwitter();
        String actualTitlePageTwitter = prop.getProperty("actualTitlePageTwitter");
//        Assert.assertEquals(expectedTitlePage, actual);
        Log.endTestCase("Test completed.");
    }


    @Test(enabled = false)
    public void validateTransferToFacebook() {
        Log.startTestCase("Transfer to Facebook.");
        indexPage = new Index_Page();
        Log.info("User is entering product name into search field.");
        searchResultPage = indexPage.searchProduct(prop.getProperty("productName"));
        Log.info("User willing to click on the product pic.");
        addToCartPage = searchResultPage.clickOnProduct();
        Log.warn("User is clicking and landing on the facebook page.");
        String expectedTitlePageFacebook = addToCartPage.doTransferFacebook();
        String actualTitlePageFacebook = prop.getProperty("actualTitlePageFacebook");
        Assert.assertEquals(expectedTitlePageFacebook, actualTitlePageFacebook);
        Log.endTestCase("Test completed.");
    }

    @Test(enabled = false)
    public void validateTransferToGoogle() {
        Log.startTestCase("Transfer to Google.");
        indexPage = new Index_Page();
        Log.info("User is entering product name into search field.");
        searchResultPage = indexPage.searchProduct(prop.getProperty("productName"));
        Log.info("User willing to click on the product pic.");
        addToCartPage = searchResultPage.clickOnProduct();
        Log.warn("User is clicking and landing on the Google page.");
        String expectedTitlePageGoogle = addToCartPage.doTransferGoogle();
        String actualTitlePageGoogle = prop.getProperty("actualTitlePageGoogle");
        Assert.assertEquals(expectedTitlePageGoogle, actualTitlePageGoogle);
        Log.endTestCase("Test completed.");
    }

    @Test(enabled = false)
    public void validateTransferToPinterest() {
        Log.startTestCase("Transfer to Pinterest.");
        indexPage = new Index_Page();
        Log.info("User is entering product name into search field.");
        searchResultPage = indexPage.searchProduct(prop.getProperty("productName"));
        Log.info("User willing to click on the product pic.");
        addToCartPage = searchResultPage.clickOnProduct();
        Log.warn("User is clicking and landing on the Pinterest page.");
        String expectedTitlePagePinterest = addToCartPage.doTransferPinterest();
        String actualTitlePagePinterest = prop.getProperty("actualTitlePagePinterest");
        Assert.assertEquals(expectedTitlePagePinterest, actualTitlePagePinterest);
        Log.endTestCase("Test completed.");
    }
}

