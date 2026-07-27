package com.automation.tests.registration;

import com.automation.basetest.BaseTest;
import com.automation.dataproviders.EmptyPasswordDataProvider;
import com.automation.dataproviders.RegistrationDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyPassword extends BaseTest {

    @Test(
            priority = 1,
            description = "R-03 - Verify user cannot register with an empty password",
            dataProvider = "EmptyPasswordDataProvider",
            dataProviderClass = EmptyPasswordDataProvider.class
    )
    public void emptyPasswordTest(String username,
                                  String email,
                                  String password) {

        // Navigate to Registration page
        registrationPage.clickCreateAccount();

        // Populate registration form using Excel data
        registrationPage.enterUsername(username);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);

        // Verify password field is invalid
        Assert.assertTrue(
                registrationPage.isPasswordFieldInvalid(),
                "Password field should be marked as invalid."
        );

        System.out.println("Empty Password Test Passed");
    }
}