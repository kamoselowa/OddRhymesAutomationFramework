package com.automation.tests.registration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.basetest.BaseTest;
import com.automation.pages.RegistrationPage;

import org.testng.annotations.Test;

public class SuccessfulRegistration extends BaseTest{
    @BeforeMethod
    public void SetupCorrectReg(){
        BaseSetup();
    }

    @Test(dataProvider = "registrationData")
public void ValidRegistrationTest(
        String firstName,
        String email,
        String password) {
    registrationPage.clickCreateAccount();

    registrationPage.registerUser(
            firstName,
            email,
            password);
}

    @AfterMethod
    public void TearDownReg(){

        closeBrowser();
    }
}
