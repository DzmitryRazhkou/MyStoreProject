package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login_Page extends BaseClass {

//    Locators/ WebElements:

    @FindBy(id = "email")
    @CacheLookup
    WebElement username;

    @FindBy(id = "passwd")
    @CacheLookup
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement submitBtn;

    @FindBy(id = "email_create")
    WebElement emailFieldForNewAccount;

    @FindBy(id = "SubmitCreate")
    WebElement emailBtnForNewAccount;

    By my_account_locator = By.xpath("//*[@class='page-heading']");

//    Constructor:

    public Login_Page() {
        PageFactory.initElements(driver, this);
    }

//    Method login:

    public Home_Page login(String user_name, String pwd) {
        Action_Driver_Perform.type(username, user_name);
        Action_Driver_Perform.type(password, pwd);
        Action_Driver_Perform.click(driver, submitBtn);
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("homePageURL")));
        return new Home_Page();
    }

//    If you didn't login into page, you would login before Address_Page:

    public Address_Page loginBeforeAddress_Page(String user_name, String pwd) {
        wait.until(ExpectedConditions.visibilityOf(username));
        Action_Driver_Perform.type(username, user_name);
        Action_Driver_Perform.type(password, pwd);
        Action_Driver_Perform.click(driver, submitBtn);
//        wait.until(ExpectedConditions.urlToBe(prop.getProperty("homePageURL")));
        return new Address_Page();
    }

    public SearchResult_Page loginSearch_Page(String user_name, String pwd) {
        wait.until(ExpectedConditions.visibilityOf(username));
        Action_Driver_Perform.type(username, user_name);
        Action_Driver_Perform.type(password, pwd);
        Action_Driver_Perform.click(driver, submitBtn);
//        wait.until(ExpectedConditions.urlToBe(prop.getProperty("homePageURL")));
        return new SearchResult_Page();
    }

//    Method createNewAccount:

    public AccountCreation_Page createNewAccount(String newEmail) {
        Action_Driver_Perform.type(emailFieldForNewAccount, newEmail);
        Action_Driver_Perform.click(driver, emailBtnForNewAccount);
        return new AccountCreation_Page();
    }
}
