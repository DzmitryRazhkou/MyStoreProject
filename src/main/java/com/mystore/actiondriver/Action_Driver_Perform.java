package com.mystore.actiondriver;

import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Action_Driver_Perform extends BaseClass {

//    Scroll By Javascript Executor

    public static void scrollByVisibilityOfElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

//    Click By Javascript Executor

    public static void JavaScriptExe_Click(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

//    Click By Action Class

    public static void click(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).click().build().perform();
    }

    public static void click_(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }



    public static void move(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }

    public static void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

//    Select (DropDown Menu)

//    a) Visible Text

    public static void SelectByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

//    b) Index

    public static void doSelectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

//    c) Value

    public static void doSelectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void maximizePage(WebDriver driver, URL url){
//        WebElement f = driver.findElements(By.id("ggdd"));
    }

//    Method for BootStrap DropDown Menu:

    public static void BootStrapDropDown(WebDriver driver, String dropDownValue, String locator_dd, String locator_value){

        driver.findElement(By.xpath(locator_dd)).click();
        List<WebElement> list = driver.findElements(By.xpath(locator_value));

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains(dropDownValue)){
                list.get(i).click();
                break;
            }
        }
    }

    public static void BootStrapDropDownDOB(WebDriver driver, String dropDownValue, String locator_dd, String locator_value){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator_dd)));
        driver.findElement(By.id(locator_dd)).click();
        List<WebElement> list = driver.findElements(By.xpath(locator_value));

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains(dropDownValue)){
                list.get(i).click();
                break;
            }
        }
    }

    public static void selectAndClick_Thru(WebDriver driver, WebElement element, String dropDownValue, String locator_dd, String locator_value) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_dd)));
        driver.findElement(By.xpath(locator_dd)).click();
        List<WebElement> list = driver.findElements(By.xpath(locator_value));

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains(dropDownValue)){
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator_value)));
                list.get(i).click();
                break;
            }
        }
    }

    public static void selectThruBootstrap(WebDriver driver, String dropDownValue, String locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
        List<WebElement> list = driver.findElements(By.xpath(locator));

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains(dropDownValue)){
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                list.get(i).click();
                break;
            }
        }
    }
}

