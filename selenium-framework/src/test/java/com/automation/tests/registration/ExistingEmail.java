package com.automation.tests.registration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.basetest.BaseTest;
import com.fasterxml.jackson.databind.JsonSerializable.Base;

public class ExistingEmail extends BaseTest{

    @BeforeMethod
    public void SetupExistingEmail(){
        BaseSetup();
    }

    @AfterMethod
    public void TearDownExistingEMail(){
        closeBrowser();
    }

}
