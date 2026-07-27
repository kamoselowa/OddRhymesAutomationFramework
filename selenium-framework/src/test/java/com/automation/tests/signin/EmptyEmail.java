package com.automation.tests.signin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;
import com.automation.pages.SignInPage;

public class EmptyEmail extends BaseTest {

    @Test(priority = 1, description = "L-02")
    public void EmptyEmailError() {

        signInPage.enterPassword("");
        // Click sign in without entering email
        signInPage.clickSignIn();

        //  ASSERT error is shown
        Assert.assertTrue(signInPage.isEmailErrorDisplayed(),
                "Email error message is not displayed");

        //  ASSERT correct message
        Assert.assertEquals(signInPage.getEmailErrorMessage(),
                "Please fill in both fields.",
                "Incorrect error message");
    }

}

