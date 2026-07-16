package com.automation.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.base.BasePage;
import com.automation.pages.RegistrationPage;
import com.automation.pages.SignInPage;
import com.automation.testdatareaders.ExcelReader;
import com.automation.utils.ConfigReader;

public class BaseTest {

    public BasePage basePage;
    public WebDriver driver;
    public RegistrationPage registrationPage;
    public SignInPage signInPage;
    public ConfigReader configReader;
    public ExcelReader excelReader;

    @BeforeMethod
    public void BaseSetup() {
        configReader = new ConfigReader(); // ✅ initialize first

        basePage = new BasePage(driver); // ✅ don't pass driver yet (or redesign constructor)
        driver = basePage.getDriver(configReader.getBrowser()); // ✅ now safe

        driver.get(configReader.getUrl());

        registrationPage = new RegistrationPage(driver);
        signInPage = new SignInPage(driver); // ✅ assign to class field
        excelReader = new ExcelReader(
                " ./src/test/java/com/automation/Resources/Configurations/Test-Data/"
                        + configReader.getFieldsVerificationExcelName());
    }

    @AfterMethod
    public void closeBrowser() {

        basePage.quitDriver();
    }

}
