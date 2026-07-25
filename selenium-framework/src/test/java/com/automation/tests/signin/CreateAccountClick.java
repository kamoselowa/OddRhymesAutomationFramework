package com.automation.tests.signin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import com.automation.basetest.BaseTest;
import com.automation.pages.SignInPage;

public class CreateAccountClick extends BaseTest{
    



    @Test
    public void CreateAccountButton(){

        SignInPage Click = new SignInPage(driver);

        Click.CreateAccount();

         String expectedUrl = "https://oddrhymes.com/signup";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);

    }



}
