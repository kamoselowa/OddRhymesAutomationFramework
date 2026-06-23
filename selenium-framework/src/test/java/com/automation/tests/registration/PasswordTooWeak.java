package com.automation.tests.registration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.basetest.BaseTest;

public class PasswordTooWeak extends BaseTest {

    @BeforeMethod
    public void SetupPasswordTesting(){
        BaseSetup();
    }
    @AfterMethod
    public void TearDownPasswordTesting(){
        closeBrowser();
    }

}
