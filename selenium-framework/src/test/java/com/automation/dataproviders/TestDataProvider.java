package com.automation.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.automation.testdatareaders.ExcelReader;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {

        ExcelReader excelReader =
                new ExcelReader("./src/test/resources/TestData.xlsx");

        return excelReader.getLoginData("Login");
    }
}