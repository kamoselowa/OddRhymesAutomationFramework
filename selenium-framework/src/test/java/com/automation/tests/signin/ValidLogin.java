package com.automation.tests.signin;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;
import com.automation.dataproviders.TestDataProvider;

public class ValidLogin extends BaseTest {


@BeforeMethod
public void SetupValidLogin() {

    BaseSetup();
}

@Test(
        priority = 1,
        description = "L-01",
        dataProvider = "loginData",
        dataProviderClass = TestDataProvider.class
)
public void ValidLoginTest(String username, String password) {

    signInPage.login(username, password);
}

@AfterMethod
public void TearDownValidLogin() {

    driver.quit();
}


}
