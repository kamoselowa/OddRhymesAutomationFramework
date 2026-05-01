package com.automation.tests.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;

public class EmptyPassword extends BaseTest {

    @BeforeMethod
    public void EmptyPassWordsetup(){
        BaseSetup();

    }
    // ❌ Empty password
    
    @Test(priority = 1, description = "L-03")
    public void EmptyPassword(){
            signInPage.enterEmail(null);;
        // Click sign in without entering email
        signInPage.clickSignIn();

        // ✅ ASSERT error is shown
        Assert.assertTrue(signInPage.isEmailErrorDisplayed(),
                "Email error message is not displayed");

        // ✅ ASSERT correct message
        Assert.assertEquals(signInPage.getEmailErrorMessage(),
                "Please fill in both fields.",
                "Incorrect error message");
    }
    @AfterMethod
    public void TeardownEmptyPass(){
        closeBrowser();
    }



}
