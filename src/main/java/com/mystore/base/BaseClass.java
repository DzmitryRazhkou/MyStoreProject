package com.mystore.base;

import com.mystore.utility.logClass.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;
    public static WebDriverWait wait;

    public BaseClass() {

        try {
            prop = new Properties();
            System.out.println("Super Constructor Invoked");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +
                    "/src/configuration/Config.properties");

            prop.load(ip);
            System.out.println("Driver: " + driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void launchApp() {
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }


//        DOMConfigurator.configure("log4j2.xml");
//        PropertyConfigurator.configure("log4j2.properties");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
    }
}
