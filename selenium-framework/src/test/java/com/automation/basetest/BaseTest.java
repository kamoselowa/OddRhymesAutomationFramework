package com.automation.basetest;

import com.automation.utils.Customwait;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.base.BasePage;
import com.automation.pages.RegistrationPage;
import com.automation.pages.SignInPage;
import com.automation.testdatareaders.ExcelReader;
import com.automation.utils.ConfigReader;

import java.time.Duration;


public class BaseTest {

    public BasePage basePage;
    public WebDriver driver;
    public RegistrationPage registrationPage;
    public SignInPage signInPage;
    public ConfigReader configReader;
    public ExcelReader excelReader;
    public Customwait wait;

    @BeforeMethod
    public void BaseSetup() {

        configReader = new ConfigReader();

        basePage = new BasePage(driver);
        driver = basePage.getDriver(configReader.getBrowser());

        // THIS MUST BE HERE
        wait = new Customwait(driver, Duration.ofSeconds(10));

        driver.get(configReader.getUrl());

        registrationPage = new RegistrationPage(driver);
        signInPage = new SignInPage(driver);

        excelReader = new ExcelReader(
                "./src/test/java/com/automation/Resources/Configurations/Test-Data/"
                        + configReader.getFieldsVerificationExcelName());
    }

    @AfterMethod
    public void closeBrowser() {

        basePage.quitDriver();
    }

}
