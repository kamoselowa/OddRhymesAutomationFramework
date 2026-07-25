package com.automation.tests.signin;


import com.automation.dataproviders.InvalidLoginTestDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;
import com.automation.dataproviders.ValidLoginTestDataProvider;

public class InvalidCredentials extends BaseTest {


    @BeforeMethod
    public void SetupValidLogin() {

        BaseSetup();
    }

    @Test(
            priority = 1,
            description = "L-01",
            dataProvider = "loginData",
            dataProviderClass = InvalidLoginTestDataProvider.class
    )
    public void ValidLoginTest(String username, String password) {

        signInPage.login(username, password);
    }

    @AfterMethod
    public void TearDownValidLogin() {

        closeBrowser();
    }


}

