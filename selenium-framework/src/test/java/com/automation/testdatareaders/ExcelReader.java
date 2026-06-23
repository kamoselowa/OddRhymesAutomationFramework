package com.automation.testdatareaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private String filePath;

    public ExcelReader(String filePath){
        public List<String>getFieldNamesFromExcel(String sheetName) throws IOException{
            List<String> fieldName = new ArrayList<>();
            try {
                FileInputStream fileiInputStream = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(fileiInputStream);
                Sheet 
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}
