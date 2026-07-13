package com.automation.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.automation.testdatareaders.ExcelReader;

public class TestDataProvider {
    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {

        ExcelReader excelReader =
                new ExcelReader(
                        "C:\\Users\\Kamogelo Selowa\\OneDrive - Dynamic DNA (PTY) LTD\\Desktop\\OddRhymesAutomationFrameworkOop\\selenium-framework\\src\\test\\java\\com\\automation\\Resources\\Configurations\\Test-Data\\Test_Data_Fields_Verification.xlsx"
                );

        return excelReader.getLoginData("Login");
    }

}