package com.automation.tests.signin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;
import com.automation.pages.SignInPage;

public class ForgotPassword extends BaseTest {


    @Test(
            priority = 1,
            description = "TC - L-06 - Forgot Password Link Test"
    )
    public void ClickLink() {
        signInPage.clickForgotPassword();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("login"),
                "Forgot Password page did not open");
        System.out.println("Forgot Password Link works Perfectly");

    }


}
