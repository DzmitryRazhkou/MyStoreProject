package com.mystore.pageobjects;

import com.mystore.actiondriver.Action_Driver_Perform;
import com.mystore.base.BaseClass;
import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountCreation_Page extends BaseClass {

    @FindBy(id = "noSlide")
    WebElement transparent_Sign;

//    Personal info:

    @FindBy(id = "id_gender1")
    WebElement radioBtnTitle;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "passwd")
    WebElement customerPwd;

//    Date of Birth:

//    Days:

    String days_locator = "days";

    String days_locatorValues = "(//*[@class='form-control'])[1]//option";

//    Months:

    String months_locator = "months";

    String months_locatorValues = "(//*[@class='form-control'])[2]//option";

//    Years:

    String years_locator = "years";

    String years_locatorValues = "(//*[@class='form-control'])[3]//option";

//    Address info:

    @FindBy(id = "firstname")
    WebElement firstNameAddressLine;

    @FindBy(xpath = "//*[@id='lastname']")
    WebElement lastNameAddressLine;

    @FindBy(id = "address1")
    WebElement addressLine1;

    @FindBy(id = "address2")
    WebElement addressLine2;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "postcode")
    WebElement zipCode;

    @FindBy(id = "other")
    WebElement addInfo;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    public AccountCreation_Page() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateAccountPage() {
        wait.until(ExpectedConditions.visibilityOf(transparent_Sign));
        return transparent_Sign.isDisplayed();
    }

    public void enterPersonalInformation(String customerFn, String customerLn, String pwd,
        String days, String months, String years, String address, String address2, String customerCity,
        String customerState, String postalCode, String additionalInfo, String cellNumber) {

        wait.until(ExpectedConditions.elementToBeClickable(radioBtnTitle));
        Action_Driver_Perform.click(driver, radioBtnTitle);   // Title (Mr./Ms.)
        Action_Driver_Perform.type(customerFirstName, customerFn);   // FirstName
        Action_Driver_Perform.type(customerLastName, customerLn);   // LastName
        Action_Driver_Perform.type(customerPwd, pwd);   // Password
        Action_Driver_Perform.BootStrapDropDownDOB(driver, days, days_locator, days_locatorValues);   // Days
        Action_Driver_Perform.BootStrapDropDownDOB(driver, months, months_locator, months_locatorValues);   // Months
        Action_Driver_Perform.BootStrapDropDownDOB(driver, years, years_locator, years_locatorValues);   // Years

        Action_Driver_Perform.type(firstNameAddressLine, customerFn); // FirstName (Address Line)
        Action_Driver_Perform.type(lastNameAddressLine, customerLn);   // LastName (Address Line)

        Action_Driver_Perform.type(addressLine1, address);   // Address First Line
        Action_Driver_Perform.type(addressLine2, address2);  // Address First Line2
        Action_Driver_Perform.type(city, customerCity);   // City
        Action_Driver_Perform.SelectByVisibleText(state, customerState);   // State
        Action_Driver_Perform.type(zipCode, postalCode);   // ZipCode
        Action_Driver_Perform.type(addInfo, additionalInfo);   // Message
        Action_Driver_Perform.type(mobilePhone, cellNumber);   // Cell Number

    }
}
