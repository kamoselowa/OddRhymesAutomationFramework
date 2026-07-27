package com.automation.tests.registration;

import com.automation.basetest.BaseTest;
import com.automation.dataproviders.WeakPasswordDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordTooWeak extends BaseTest {

    @Test(
            priority = 4,
            description = "R-04 - Verify user cannot register with a password shorter than 8 characters",
            dataProvider = "weakPasswordData",
            dataProviderClass = WeakPasswordDataProvider.class
    )
    public void weakPasswordTest(String username,
                                 String email,
                                 String password) {

        // Navigate to Registration page
        registrationPage.clickCreateAccount();

        // Populate registration form
        registrationPage.enterUsername(username);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);

        // Submit registration
        registrationPage.clickCreateAccount();

        // User should still be on the registration page
        Assert.assertTrue(
                registrationPage.getCurrentUrl().contains("register"),
                "User should remain on the registration page when the password is less than 8 characters."
        );
    }
}