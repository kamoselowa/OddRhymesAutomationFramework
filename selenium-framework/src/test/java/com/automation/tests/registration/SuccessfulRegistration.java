package com.automation.tests.registration;

import com.automation.basetest.BaseTest;
import com.automation.dataproviders.RegistrationDataProvider;
import com.automation.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulRegistration extends BaseTest {

    @Test(
            dataProvider = "registrationData",
            dataProviderClass = RegistrationDataProvider.class
    )
    public void ValidRegistrationTest(
            String firstName,
            String email,
            String password) {

        registrationPage.clickCreateAccount();

        registrationPage.registerUser(
                firstName,
                email,
                password
        );
        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.Profileisdisplayed();

        Assert.assertTrue(wait.waitForUrlContains("https://oddrhymes.com/profile/"));
    }
}