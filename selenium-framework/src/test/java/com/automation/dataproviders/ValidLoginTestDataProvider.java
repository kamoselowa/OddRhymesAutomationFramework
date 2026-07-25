package com.automation.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.automation.testdatareaders.ExcelReader;

public class ValidLoginTestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {

        ExcelReader excelReader = new ExcelReader(
                System.getProperty("user.dir")
                        + "/src/test/java/com/automation/Resources/Configurations/Test-Data/Test_Data_Fields_Verification.xlsx");

        return excelReader.getLoginData("ValidLoginCredentials");
    }
}