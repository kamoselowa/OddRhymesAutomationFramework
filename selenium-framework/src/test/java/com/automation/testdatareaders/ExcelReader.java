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
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < colCount; j++) {

                if (row.getCell(j) != null) {
                    data[i - 1][j] = row.getCell(j).toString();
                } else {
                    data[i - 1][j] = "";
                }
            }
        }

        return data;
    }
}


}
