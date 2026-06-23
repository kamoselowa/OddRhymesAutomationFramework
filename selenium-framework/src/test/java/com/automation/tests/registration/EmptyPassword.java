package com.automation.tests.registration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.basetest.BaseTest;

public class EmptyPassword extends BaseTest{

    @BeforeMethod
    public void EmptyPasswordSetup(){
        BaseSetup();

    }
    @AfterMethod
    public void TearDownEmptypassWord(){
        closeBrowser();
    }

}
