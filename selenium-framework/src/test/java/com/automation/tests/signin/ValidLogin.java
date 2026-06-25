package com.automation.tests.signin;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;
import com.automation.pages.SignInPage;
import com.automation.testdatareaders.ExcelReader;

public class ValidLogin extends BaseTest {
    @BeforeMethod

    public void SetupValidLogin(){
        BaseSetup();

    }
    @Test(priority = 1 , description = "L-01")
    public void ValidLoginTest(){

        signInPage.login(null, null);
    }

     @Test
    public void fieldsOnThePageTest() throws IOException {

		List<String> fieldNames = excelReader.getFieldNamesFromExcel("RegistrationPage");
		Assert.assertTrue(signInPage.verifyPresenceOfElementsOnPage(fieldNames),
				"Some elements are not present on the registration page.");
    }


    @AfterMethod
    public void TearDiownValidLogin(){
        driver.close();
    
    }
}