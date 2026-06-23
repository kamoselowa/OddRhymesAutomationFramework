package com.automation.tests.signin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;

public class InvalidCredentials extends BaseTest{
    @BeforeMethod
    public void InvalidSetup(){
        BaseSetup();

    }
    @Test(priority = 1, description = "L-04")
    public void InvalidUser(){
        
    }

}
