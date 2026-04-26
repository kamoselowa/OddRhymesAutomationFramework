package com.automation.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.base.BasePage;
import com.automation.pages.RegistrationPage;
import com.automation.pages.SignInPage;
import com.automation.utils.ConfigReader;

public class BaseTest {
    
    public BasePage basePage;
    public WebDriver driver;
    public  RegistrationPage registrationPage;
    public SignInPage signInPage;
    public ConfigReader configReader; 


    @BeforeMethod
    public void BaseSetup(){
        basePage = new BasePage();
        driver = basePage.getDriver(configReader.getBrowser());
        configReader = new ConfigReader();
        driver.get(configReader.getUrl());
        registrationPage = new RegistrationPage();
        SignInPage signInPage = new SignInPage();

    }
    @AfterMethod
    public void closeBrowser(){
        basePage.quitDriver();
    }

}
