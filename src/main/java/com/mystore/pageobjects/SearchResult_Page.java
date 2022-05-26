package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResult_Page extends BaseClass {

//    Locators/ WebElements:

    @FindBy(xpath = "//*[@class='breadcrumb clearfix']")
    WebElement search_Home_Validation;

    @FindBy(id = "search_query_top")
    WebElement searchField_searchPage;

    @FindBy(xpath = "//*[@name='submit_search']")
    WebElement submit_Search_Icon_HomePage;

    @FindBy(xpath = "//*[@class='product-container']")
    WebElement productResult;

//    Constructor:

    public SearchResult_Page() {
        PageFactory.initElements(driver, this);
    }

//    Method validateSearchProduct:

    public boolean validateSearchProduct() {
        return productResult.isDisplayed();
    }

//    Method clickOnProduct:

    public AddToCart_Page clickOnProduct() {
        wait.until(ExpectedConditions.visibilityOf(productResult));
        Action_Driver_Perform.click(driver, productResult);
        return new AddToCart_Page();
    }

    public void searchProduct(String productName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(searchField_searchPage));
        Thread.sleep(2000);
        Action_Driver_Perform.type(searchField_searchPage, productName);
        Action_Driver_Perform.click(driver, submit_Search_Icon_HomePage);   //ggtt
    }

    public boolean validatePage(){
        wait.until(ExpectedConditions.visibilityOf(search_Home_Validation));
        return search_Home_Validation.isDisplayed();
    }
}
