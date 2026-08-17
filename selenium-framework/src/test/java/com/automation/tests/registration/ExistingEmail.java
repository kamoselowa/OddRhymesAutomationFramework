package com.automation.tests.registration;

import com.automation.dataproviders.RegistrationDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.basetest.BaseTest;
import com.fasterxml.jackson.databind.JsonSerializable.Base;
import org.testng.annotations.Test;

import static org.bouncycastle.cms.RecipientId.password;

public class ExistingEmail extends BaseTest{
@Test (dataProvider = "registrationData",
    dataProviderClass = RegistrationDataProvider .class)
    public  void existingEmail(String firstName,
                               String email,
                               String password){
     {

        registrationPage.clickCreateAccount();

        registrationPage.registerUser(
                firstName,
                email,
                password
        );
    }





    }


}
