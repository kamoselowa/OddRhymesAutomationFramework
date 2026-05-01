package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;

public class SignInTest extends BaseTest {

    //priority of Test beging from 1 to 3
    //1  which is high priority 
    //2 which is medium 
    // 3 which is low


    @BeforeMethod
    public void setupSignInTest() {
        BaseSetup(); // launch browser + init pages
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser(); // close browser after each test
    }

    
   
 

    // ✅ Valid login test
    @Test(priority = 1, description = "L-01")
    public void validLoginTest() {
        signInPage.login("test@mail.com", "Password123");

       
    }

    
   


    // ❌ Invalid email format
    @Test(priority = 1 , description = "L-04")
    public void invalidEmailFormatTest() {
        signInPage.login("invalid-email", "Password123");

        Assert.assertTrue(signInPage.isErrorDisplayed(),
                "Error message should appear for invalid email format");
    }

    // 🔁 Dynamic quote test
    @Test(priority = 7)
    public void verifyQuoteChanges() {
        Assert.assertTrue(signInPage.isQuoteNotEmpty(),
                "Quote should not be empty");

        Assert.assertTrue(signInPage.doesQuoteChange(),
                "Quote is not changing over time");
    }

    // 🔗 Forgot password link
    @Test(priority = 8)
    public void verifyForgotPasswordLink() {
        signInPage.clickForgotPassword();

        // 👉 Replace with actual assertion (URL or page)
        // Example:
        // Assert.assertTrue(driver.getCurrentUrl().contains("forgot-password"));
    }

    // 🔗 Learn more link
    @Test(priority = 9)
    public void verifyLearnMoreLink() {
        signInPage.clickLearnMore();

        // 👉 Replace with actual assertion
        // Assert.assertTrue(driver.getTitle().contains("About"));
    }
}