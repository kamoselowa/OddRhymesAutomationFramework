package com.automation.testdatareaders;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public Object[][] getLoginData(String sheetName) throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            int rowCount = sheet.getPhysicalNumberOfRows();

            // Only read Username and Password columns
            Object[][] data = new Object[rowCount - 1][2];

            for (int i = 1; i < rowCount; i++) {

                Row row = sheet.getRow(i);

                data[i - 1][0] = row.getCell(0) != null
                        ? row.getCell(0).toString()
                        : "";

                data[i - 1][1] = row.getCell(1) != null
                        ? row.getCell(1).toString()
                        : "";
            }

            return data;
        }
    }
}