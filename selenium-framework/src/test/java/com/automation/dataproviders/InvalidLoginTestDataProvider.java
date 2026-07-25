package com.automation.dataproviders;

import com.automation.testdatareaders.ExcelReader;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class InvalidLoginTestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {

        ExcelReader excelReader = new ExcelReader(
                System.getProperty("user.dir")
                        + "/src/test/java/com/automation/Resources/Configurations/Test-Data/Test_Data_Fields_Verification.xlsx");

        return excelReader.getLoginData("Login");
    }
}

