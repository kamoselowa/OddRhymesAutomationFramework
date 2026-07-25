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

            // Number of data rows (excluding header)
            int totalRows = sheet.getPhysicalNumberOfRows() - 1;

            // Read a maximum of 3 rows
            int rowsToRead = Math.min(totalRows, 3);

            // Only Username and Password columns
            Object[][] data = new Object[rowsToRead][2];

            for (int i = 1; i <= rowsToRead; i++) {

                Row row = sheet.getRow(i);

                data[i - 1][0] = (row != null && row.getCell(0) != null)
                        ? row.getCell(0).toString()
                        : "";

                data[i - 1][1] = (row != null && row.getCell(1) != null)
                        ? row.getCell(1).toString()
                        : "";
            }

            return data;
        }
    }
}