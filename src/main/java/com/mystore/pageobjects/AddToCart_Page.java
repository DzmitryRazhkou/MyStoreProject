package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;

public class AddToCart_Page extends BaseClass {

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(id = "group_1")
    WebElement size;

    @FindBy(xpath = "//*[contains(text(),'Add to cart')]")
    WebElement addToCardBtn;

    @FindBy(xpath = "//*[@class='icon-ok']")
    WebElement validateProductSuccess;

    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    WebElement proceedToCheckOutBtn;

    @FindBy(xpath = "//a[@id='wishlist_button']")
    WebElement addToWishList_icon;

    @FindBy(xpath = "//*[@class='fancybox-error']")
    WebElement addedToYourWish;

    @FindBy(xpath = "//*[@title='Close']")
    WebElement cross;

    @FindBy(xpath = "//a[contains(text(),'Write a review')]")
    WebElement writeReviewBtn;

    @FindBy(id = "comment_title")
    WebElement title;

    @FindBy(id = "content")
    WebElement content;

    @FindBy(xpath = "//button[@id='submitNewMessage']")
    WebElement sendBtn;

    @FindBy(xpath = "//h2[contains(text(),'New comment')]")
    WebElement new_message;

//    Send to Friend:

    @FindBy(id = "send_friend_button")
    WebElement sent_to_friend;

    @FindBy(id = "friend_name")
    WebElement nameOfFriend;

    @FindBy(id = "friend_email")
    WebElement emailOfFriend;

    @FindBy(id = "sendEmail")
    WebElement sendBtn_SendToFriend;

    @FindBy(xpath = "(//h2[contains(text(),'Send to a friend')])[2]")
    WebElement sendToFriend_message;

//    Links:
//    Twitter:

    @FindBy(xpath = "//button[@class='btn btn-default btn-twitter']")
    WebElement twitter;

    By twit_Locator = By.xpath("//span[normalize-space()='Want to log in first?']");

//    Facebook:

    @FindBy(xpath = "//button[@class='btn btn-default btn-facebook']")
    WebElement facebook;

    By login_Locator = By.xpath("//*[@name='login']");

//    Google:

    @FindBy(css = ".btn.btn-default.btn-google-plus")
    WebElement google;
    
    //button[@class='btn btn-default btn-google-plus']

    By email_Locator = By.xpath("//*[@id='identifierId']");

//    Pinterest:

    @FindBy(xpath = "//*[@class='btn btn-default btn-pinterest']")
    WebElement pinterest;

    By pin_Locator = By.xpath("//h1[normalize-space()='Sign in to save this Pin!']");

    String rate = "//*[@class='star_content']//div";

    By shoppingCartSummary_locator = By.id("cart_title");

    By write_review_locator = By.xpath("//*[@class='fancybox-skin']");


    public AddToCart_Page() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void enterQuantity(String hm) {
        wait.until(ExpectedConditions.visibilityOf(quantity));
        Action_Driver_Perform.type(quantity, hm);
    }

    public void selectSize(String value_size) {
        Action_Driver_Perform.SelectByVisibleText(size, value_size);
    }

    public void clickOnAddToCart() {
        Action_Driver_Perform.click(driver, addToCardBtn);
    }

    public boolean validateAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(validateProductSuccess));
        return validateProductSuccess.isDisplayed();
    }

    public Order_Page clickOnProceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckOutBtn));
        Action_Driver_Perform.JavaScriptExe_Click(driver, proceedToCheckOutBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCartSummary_locator));
        return new Order_Page();
    }

    public void addToWishlist() {
        wait.until(ExpectedConditions.visibilityOf(addToWishList_icon));
        Action_Driver_Perform.click(driver, addToWishList_icon);

    }

    public boolean validateAddElement() {
        wait.until(ExpectedConditions.visibilityOf(addedToYourWish));
        return addedToYourWish.isDisplayed();
    }

    public void closeAddWish() {
        wait.until(ExpectedConditions.elementToBeClickable(cross));
        Action_Driver_Perform.click(driver, cross);
    }

//    Write Review:

    public void createWriteReview(String dropDownValue) {
        wait.until(ExpectedConditions.visibilityOf(writeReviewBtn));
        Action_Driver_Perform.click(driver, writeReviewBtn);
        Action_Driver_Perform.selectThruBootstrap(driver, dropDownValue, rate);
        Action_Driver_Perform.type(title, prop.getProperty("title"));
        Action_Driver_Perform.type(content, prop.getProperty("comment"));
        wait.until(ExpectedConditions.visibilityOf(sendBtn));
        Action_Driver_Perform.click(driver, sendBtn);
    }

    public String validateNewComment() {
        wait.until(ExpectedConditions.visibilityOf(new_message));
        String newMessage = new_message.getText();
        return newMessage;
    }

//    Send to Friend:

    public void doSendToFriend(String friendName, String friendEmail){
        wait.until(ExpectedConditions.visibilityOf(sent_to_friend));
        Action_Driver_Perform.click(driver, sent_to_friend);
        Action_Driver_Perform.type(nameOfFriend, friendName);
        Action_Driver_Perform.type(emailOfFriend, friendEmail);
        wait.until(ExpectedConditions.visibilityOf(sendBtn_SendToFriend));
        Action_Driver_Perform.click(driver, sendBtn_SendToFriend);
    }

    public String validateSendToFriend() {
        wait.until(ExpectedConditions.visibilityOf(sendToFriend_message));
        String sendToFriend_messageTextMessage = sendToFriend_message.getText();
        return sendToFriend_messageTextMessage;
    }

//    Links Tests:

//    Twitter:

    public String doTransferTwitter() {
        wait.until(ExpectedConditions.visibilityOf(twitter));
        Action_Driver_Perform.click(driver, twitter);
        Set<String> pages = driver.getWindowHandles();
        Iterator<String> it = pages.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        if (!parentWindowId.equalsIgnoreCase(childWindowId)) {
            driver.switchTo().window(childWindowId);
        }
        try {
            wait.until(ExpectedConditions.elementToBeClickable(twit_Locator));
            String expectedPage_Twitter = driver.getTitle();
            return expectedPage_Twitter;

        } catch (NoSuchSessionException e){
            e.printStackTrace();
        }
        return null;

    }

//    Facebook:

    public String doTransferFacebook() {
        wait.until(ExpectedConditions.visibilityOf(facebook));
        Action_Driver_Perform.click(driver, facebook);
        Set<String> pages = driver.getWindowHandles();
        Iterator<String> it = pages.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        if (!parentWindowId.equalsIgnoreCase(childWindowId)) {
            driver.switchTo().window(childWindowId);
        }
        wait.until(ExpectedConditions.elementToBeClickable(login_Locator));
        String expectedPage_Facebook = driver.getTitle();
        return expectedPage_Facebook;
    }


//    Google:

    public String doTransferGoogle() {
        wait.until(ExpectedConditions.visibilityOf(google));
        Action_Driver_Perform.click(driver, google);
        Set<String> pages = driver.getWindowHandles();
        Iterator<String> it = pages.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        if (!parentWindowId.equalsIgnoreCase(childWindowId)) {
            driver.switchTo().window(childWindowId);
        }
        wait.until(ExpectedConditions.elementToBeClickable(email_Locator));
        String expectedPage_Google = driver.getTitle();
        return expectedPage_Google;
    }


    //    Pinterest:

    public String doTransferPinterest() {
        wait.until(ExpectedConditions.visibilityOf(pinterest));
        Action_Driver_Perform.click(driver, pinterest);
        Set<String> pages = driver.getWindowHandles();
        Iterator<String> it = pages.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        if (!parentWindowId.equalsIgnoreCase(childWindowId)) {
            driver.switchTo().window(childWindowId);
        }
        wait.until(ExpectedConditions.elementToBeClickable(pin_Locator));
        String expectedPage_Pinterest = driver.getTitle();
        return expectedPage_Pinterest;
    }
}
