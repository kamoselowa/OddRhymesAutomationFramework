package com.automation.tests.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BasePage;
import com.automation.basetest.BaseTest;
import com.automation.pages.SignInPage;

public class VerifyTitle extends BaseTest {

   
    @BeforeMethod
    public void SetupVerifyPage(){ 
        BaseSetup();
            
    }

    
    @Test(priority = 3)
    public void verifyTitle(){
        Assert.assertTrue(signInPage.isPageLoaded(), 
        "Page title is not displayed" );

        Assert.assertEquals(signInPage.getPageTitleText(),
                "Odd Rhymes",
                "Page title text mismatch");
            //low priority UI LOgo Check
          Assert.assertTrue(signInPage.isPageLoaded(),
                "Logo is not displayed");

       
    }
    
    @AfterMethod
    public void tearDownVerifyPage(){
        closeBrowser();
    }

}
