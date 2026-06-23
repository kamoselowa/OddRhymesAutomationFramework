 package com.automation.tests.registration;

import com.automation.base.BasePage;
import com.automation.basetest.BaseTest;

public class InvalidEmailFormat extends BaseTest{
    
    public void InvalidFormatSetup(){
        BaseSetup();

    }

    public void TearDownInvalidAcc(){
        closeBrowser();
    }

}
