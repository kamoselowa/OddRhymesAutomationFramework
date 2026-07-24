package com.automation.tests.registration;

import com.automation.basetest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ServerError extends BaseTest {
@BeforeMethod
    public void ServerErrorSetup(){
    BaseSetup();
}
@AfterMethod
    public void TearDownServer(){
    closeBrowser();
}
}
