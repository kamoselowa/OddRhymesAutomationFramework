package com.automation.tests.registration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.basetest.BaseTest;
import org.testng.annotations.Test;

public class SignInRedirect extends BaseTest {


    @Test
    public void AssertPageNavigations() {
       registrationPage.clickCreateAccount();

       registrationPage.clickSignIn();

        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals("https://oddrhymes.com/login")) {
            System.out.println("Correct navigation page.");
        } else {
            Assert.fail("Incorrect page. Current URL is: " + actualUrl);
        }

    }
}