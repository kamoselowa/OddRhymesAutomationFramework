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

        Object[][] loginData = excelReader.getLoginData("Login");
        int testDataRowNumber = 3;

        if (loginData.length < testDataRowNumber) {
            throw new IllegalStateException(
                    "Expected at least " + testDataRowNumber + " login data rows, found " + loginData.length);
        }

        return new Object[][] { loginData[testDataRowNumber - 1] };
    }
}
