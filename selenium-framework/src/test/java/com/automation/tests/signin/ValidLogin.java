package com.automation.tests.signin;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;

public class ValidLogin extends BaseTest {
    @BeforeMethod

    public void SetupValidLogin(){
        BaseSetup();

    }
    @Test(priority = 1 , description = "L-01")
    public void ValidLoginTest(){

        signInPage.login(null, null);
    }

    @AfterMethod
    public void tearDownValidLogin(){
        closeBrowser();
    }
    @Test
    public void fieldsOnThePageTest()throws IOException{
        List<String> fiEldNames = excelReader.getFieldNamesFromExcel("SignInPage");
    }

}
