package com.automation.tests.registration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.basetest.BaseTest;
import org.testng.annotations.Test;

public class PasswordTooWeak extends BaseTest {

    @BeforeMethod
    public void SetupPasswordTesting(){
        BaseSetup();
    }
    @Test

    @AfterMethod
    public void TearDownPasswordTesting(){
        closeBrowser();
    }

}
