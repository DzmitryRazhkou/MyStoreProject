package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class Home_Page extends BaseClass {

//    Locators/ WebElements:

    @FindBy(xpath = "//*[contains(text(),'My wishlists')]")
    WebElement myWishLists;

    @FindBy(xpath = "//*[contains(text(),'Order history and details')]")
    WebElement orderHistoryAndDetails;

    @FindBy(id = "search_query_top")
    WebElement searchField_HomePage;

    @FindBy(xpath = "//*[@name='submit_search']")
    WebElement submit_Search_Icon_HomePage;

    @FindBy(id = "contact-link")
    WebElement contactUs_Btn;

    @FindBy(className = "home")
    WebElement returnHome_Btn;



    @FindBy(id = "newsletter-input")
    WebElement newsletter;

    @FindBy(name = "submitNewsletter")
    WebElement newsletterBtn;



    By accountSection = By.cssSelector("#center_column span");

    By informationSection = By.cssSelector("#block_various_links_footer ul li");

    By myAccountSection = By.cssSelector("//*[@class='block_content toggle-footer']//ul//li");


//    Constructor:

    public Home_Page() {
        PageFactory.initElements(driver, this);
    }

//    Method validateTitlePage:

    public String validateHomePage() {
        wait.until(ExpectedConditions.titleIs(prop.getProperty("titlePage")));
        System.out.println("The Title of Page is: " +driver.getTitle());
        return driver.getTitle();
    }

//    Method clickOnNewsletter:

    public Index_Page clickOnNewsletter(String email) {
        wait.until(ExpectedConditions.visibilityOf(newsletter));
        Action_Driver_Perform.type(newsletter, email);
        Action_Driver_Perform.click(driver, newsletterBtn);
        return new Index_Page();
    }

//    Method getCurrentURL:

    public String getCurrentURL() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    public SearchResult_Page searchProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOf(searchField_HomePage));
        Action_Driver_Perform.type(searchField_HomePage, productName);
        Action_Driver_Perform.click(driver, submit_Search_Icon_HomePage);
        return new SearchResult_Page();
    }

    public ContactUs_Page clickOnContactUsButton(){
        wait.until(ExpectedConditions.visibilityOf(contactUs_Btn));
        Action_Driver_Perform.click(driver, contactUs_Btn);
        return new ContactUs_Page();
    }

    public Index_Page goToReturnToHome(){
        wait.until(ExpectedConditions.visibilityOf(returnHome_Btn));
        Action_Driver_Perform.click(driver, returnHome_Btn);
        return new Index_Page();
    }

    public List<String> getAccountSection() {
        List<String> accountList = new ArrayList<>();
        List<WebElement> actualAccountSection = driver.findElements(accountSection);   // From Selenium
        for (WebElement s: actualAccountSection){
            String textSection = s.getText();
            System.out.println(textSection);
            accountList.add(textSection);
        }
        return accountList;
    }

}
