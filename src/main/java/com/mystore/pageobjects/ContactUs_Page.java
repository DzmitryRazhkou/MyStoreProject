package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUs_Page extends BaseClass {

//    Locators/ WebElements:

//    ContactUs Button:

    @FindBy(className = "navigation_page")
    WebElement contact_element;

//    Subject Heading:

    String subject_Locator = "//*[@id='id_contact']";

    String subjectValueLocator = "//*[@id='id_contact']//option";

//    Order Reference:

    String order_Locator = "//*[@name='id_order']";

    String orderValue_Locator = "//*[@name='id_order']//option";

//    Product:

    String product_Locator = "//*[@id='uniform-413540_order_products']";

    String productValue_Locator = "//*[@id='uniform-413540_order_products']//select//option";

//    Message Field:

    @FindBy(id = "message")
    WebElement message_Field;

//    Send Button:

    @FindBy(xpath = "//*[contains(text(),'Send')]")
    WebElement send_Btn;



//    Constructor:

    public ContactUs_Page() {
        PageFactory.initElements(driver, this);
    }

//    Method Validate ContactUs Page:

    public boolean validateContactUsPage(){
        return contact_element.isDisplayed();
    }

//    Method Filling Up Form:

    public CustomerService_ContactUsPage fillUpRequest(String message) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(subject_Locator)));
        Action_Driver_Perform.BootStrapDropDown(driver, prop.getProperty("subjectHeading"), subject_Locator, subjectValueLocator);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(order_Locator)));
        Action_Driver_Perform.BootStrapDropDown(driver, prop.getProperty("orderValue"), order_Locator, orderValue_Locator);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(product_Locator)));
        Action_Driver_Perform.BootStrapDropDown(driver, prop.getProperty("productValue"), product_Locator, productValue_Locator);

        Action_Driver_Perform.type(message_Field, message);
        Action_Driver_Perform.click(driver, send_Btn);
        return new CustomerService_ContactUsPage();

    }
}
