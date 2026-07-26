package com.automation.tests.registration;

import com.automation.basetest.BaseTest;
import com.automation.dataproviders.RegistrationDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyEmail extends BaseTest {

    @Test(
            priority = 1,
            description = "R-02 - Verify user cannot register with an empty email",
            dataProvider = "registrationData",
            dataProviderClass = RegistrationDataProvider.class
    )
    public void emptyEmailTest(String username,
                               String email,
                               String password) {

        // Navigate to Registration Page
        registrationPage.clickCreateAccount();

        // Populate registration form using Excel data
        registrationPage.enterUsername(username);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);

        // Submit registration
        registrationPage.clickCreateAccount();

        // Verify email field is invalid
        Assert.assertTrue(
                registrationPage.isEmailFieldInvalid(),
                "Email field should be marked as invalid."
        );

        System.out.println("Empty Email Test Passed");
    }
}