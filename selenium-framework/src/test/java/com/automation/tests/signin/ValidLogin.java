package com.automation.tests.signin;


import com.automation.utils.Customwait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;
import com.automation.dataproviders.ValidLoginTestDataProvider;

import java.time.Duration;

public class ValidLogin extends BaseTest {

@Test(
        priority = 1,
        description = "L-01",
        dataProvider = "loginData",
        dataProviderClass = ValidLoginTestDataProvider.class
)
public void ValidLoginTest(String username, String password) {

    signInPage.login(username, password);
    Customwait wait = new Customwait(driver, Duration.ofSeconds(10));
    Assert.assertTrue(wait.waitForUrlContains("https://oddrhymes.com/profile/Seasonal_Lady!"),
            "Login Failed for user" + username);

}





}
