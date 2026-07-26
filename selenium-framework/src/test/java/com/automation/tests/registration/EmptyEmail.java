package com.automation.tests.registration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;

public class EmptyEmail extends BaseTest {

    @Test(
            priority = 1,
            description = "R-02 - Verify user cannot register with an empty email"
    )
    public void emptyEmailTest() {
        registrationPage.clickCreateAccount();

        registrationPage.enterUsername("Kamogelo");

        // Leave email empty
        registrationPage.enterEmail("");

        registrationPage.enterPassword("Password123!");

        //registrationPage.clickCreateAccount();

        Assert.assertTrue(
                registrationPage.isEmailFieldInvalid(),
                "Email field should be marked as invalid."
        );

        System.out.println("Empty Email Test Passed");
    }
}