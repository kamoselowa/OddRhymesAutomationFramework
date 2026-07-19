package com.automation.tests.registration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.basetest.BaseTest;
import com.fasterxml.jackson.databind.JsonSerializable.Base;
import org.testng.annotations.Test;

public class ExistingEmail extends BaseTest{

    @BeforeMethod
    public void SetupExistingEmail(){
        BaseSetup();
    }

    @Test
    public void EmptyEmailFields(){

    }

    @AfterMethod
    public void TearDownExistingEMail(){
        closeBrowser();
    }

}
