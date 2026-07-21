package com.automation.tests.registration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.basetest.BaseTest;
import org.testng.annotations.Test;

public class SignInRedirect extends BaseTest {

    @BeforeMethod
    public void RedirectSetup(){

        BaseSetup();

       
    }
    @Test
    @AfterMethod
    public void TearDownRedirect(){
        closeBrowser();
    }

}
