package com.automation.tests.registration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.basetest.BaseTest;

public class SuccessfulRegistration extends BaseTest{
    @BeforeMethod
    public void SetupCorrectReg(){
        BaseSetup();
    }
    @AfterMethod
    public void TearDownReg(){

        closeBrowser();
    }
}
