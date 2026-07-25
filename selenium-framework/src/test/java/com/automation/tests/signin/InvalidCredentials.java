package  com.automation.tests.signin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;
import com.automation.dataproviders.InvalidLoginTestDataProvider;

public class InvalidCredentials extends BaseTest {




    @Test(
            priority = 1,
            description = "L-02 - Verify user cannot login with invalid credentials",
            dataProvider = "loginData",
            dataProviderClass = InvalidLoginTestDataProvider.class
    )
    public void invalidLoginTest(String username, String password) {

        // Login with invalid credentials
        signInPage.login(username, password);

        // Wait for the error message to appear
        wait.waitForElementVisible(signInPage.getEmailErrorElement());

        // Verify the error message is displayed
        Assert.assertTrue(
                signInPage.isEmailErrorDisplayed(),
                "Login error message was not displayed."
        );

        // Verify the error message text
        Assert.assertEquals(
                signInPage.getEmailErrorMessage(),
                "Invalid email or password",
                "Unexpected error message."
        );

        System.out.println("Invalid Login Test Passed");
    }



}