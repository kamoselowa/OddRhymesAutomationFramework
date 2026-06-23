package com.automation.tests.signin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;
import com.automation.pages.SignInPage;

public class ForgotPassword extends BaseTest{
    SignInPage signInPage;

   @BeforeMethod
   public void ForgotPassSetup(){
    BaseSetup();

    signInPage = new SignInPage(driver);

   }
   @Test
   public void ClickLink(){
    signInPage.clickForgotPassword();

    String currentUrl = driver.getCurrentUrl();

    Assert.assertTrue(
        currentUrl.contains("Forgot"),
          "Forgot Password page did not open"
        );
        System.out.println("Forgot Password Link works Perfectly");
  
    }

    public void LinkTearDown(){
        closeBrowser();
    }
}
