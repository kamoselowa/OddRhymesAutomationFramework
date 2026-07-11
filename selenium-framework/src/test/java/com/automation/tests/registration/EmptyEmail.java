package com.automation.tests.registration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.basetest.BaseTest;

public class EmptyEmail extends BaseTest {
     @BeforeMethod
    public void SetupEmptyEmail(){
        BaseSetup();

    }

    @Test
    public void BEFore(){
        
    }

    
    @AfterMethod
    public void TearEmptyAcc(){
        closeBrowser();
    }
}
    
