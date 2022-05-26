package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.categories.dresses.Casual_Dresses;
import com.mystore.pageobjects.categories.dresses.Evening_Dresses;
import com.mystore.pageobjects.categories.dresses.Summer_Dresses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Index_Page extends BaseClass {

//    Locators/ WebElements:

    @FindBy(xpath = "//*[@class='login']")
    WebElement signInBtn;

    @FindBy(xpath = "//*[@class='logo img-responsive']")
    WebElement logo;

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(name = "submit_search")
    WebElement submit_Search_Icon;

//    Icons:

    @FindBy(xpath = "//a[@title='Women']")
    WebElement women_icon;

    By email_wait = By.id("email");

    @FindBy(xpath = "(//*[@class='product-container'])[1]")
    WebElement product;

//    Strings For Locators:

    @FindBy(xpath = "(//a[contains(@title,'Find your favorites dresses from our wide choice of evening, casual or summer dresses!')][normalize-space()='Dresses'])[1]/following-sibling::ul/li")
    WebElement dress_Value;

    @FindBy(xpath = "(//a[contains(@title,'Find your favorites dresses from our wide choice of evening, casual or summer dresses!')][normalize-space()='Dresses'])[1]")
    WebElement dress_Btn;

    @FindBy(xpath = "(//a[@title='Browse our different dresses to choose the perfect dress for an unforgettable evening!'][normalize-space()='Evening Dresses'])[1]")
    WebElement evening_dress;

    @FindBy(xpath = "//div[@class='block_content']//a[contains(@title,'You are looking for a dress for every day? Take a look at')][normalize-space()='Casual Dresses']")
    WebElement casual_dress;

    @FindBy(xpath = "//div[@class='block_content']//a[@title='Short dress, long dress, silk dress, printed dress, you will find the perfect dress for summer.'][normalize-space()='Summer Dresses']")
    WebElement summer_dress;

    @FindBy(className = "alert alert-success")
    WebElement greenMessage;

//    Constructor:

    public Index_Page() {
        PageFactory.initElements(driver, this);
    }


//    Method clickOnSignIn:

    public Login_Page clickOnSignIn() {
        Action_Driver_Perform.click(driver, signInBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(email_wait));
        return new Login_Page();
    }

//    Method validateLogo:

    public boolean validateLogo() {
        return logo.isDisplayed();
    }

//    Method getMyStoreTitle:

    public String getMyStoreTitle() {
        String myStoreTitle = driver.getTitle();
        return myStoreTitle;
    }

//    Method searchProduct:

    public SearchResult_Page searchProduct(String productName) {
        Action_Driver_Perform.type(searchField, productName);
        Action_Driver_Perform.click(driver, submit_Search_Icon);
        return new SearchResult_Page();
    }

    public void clickOnWomen_icon() {
        wait.until(ExpectedConditions.visibilityOf(women_icon));
        Action_Driver_Perform.click(driver, women_icon);
    }

    public void clickOnDress() {
        Action_Driver_Perform.click_(dress_Btn);
    }

    public Evening_Dresses clickOnEveningDress() {
        Action_Driver_Perform.click_(evening_dress);
        return new Evening_Dresses();
    }

    public Casual_Dresses clickOnCasualDress() {
        Action_Driver_Perform.click_(casual_dress);
        return new Casual_Dresses();
    }

    public Summer_Dresses clickOnSummerDress() {
        Action_Driver_Perform.click_(summer_dress);
        return new Summer_Dresses();
    }

    public AddToCart_Page clickOnProduct() {
        wait.until(ExpectedConditions.visibilityOf(product));
        Action_Driver_Perform.click(driver, product);
        return new AddToCart_Page();
    }

//    Method getGreenValidation:

    public String getGreenValidation() {
        wait.until(ExpectedConditions.visibilityOf(greenMessage));
        String alert = greenMessage.getText();
        System.out.println("Alert Message is: " + alert);
        return alert;
    }
}
