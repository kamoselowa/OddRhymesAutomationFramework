package com.automation.tests.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;

public class ValidLogin extends BaseTest {
    @BeforeMethod

    public void SetupValidLogin(){
        BaseSetup();

    }
    @Test(priority = 1 , description = "L-01")
    public void ValidLoginTest(){
        signInPage.login(null, null);
    }

    @AfterMethod
    public void tearDownValidLogin(){
        closeBrowser();
    }

}
