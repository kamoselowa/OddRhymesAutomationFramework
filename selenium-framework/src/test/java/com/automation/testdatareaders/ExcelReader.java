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

  public ExcelReader(String filepath){
    this.filePath = filepath;
  }
  public List<String> getFielNameFromExcel(String SheetName) throws IOException{
    List<String> fileNames = new ArrayList<>();
    try {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rows = sheet.getphysicalNumberOfRows();
        for (int row = 1 ; row< rows; row++){
            fieldNames.add(sheet.getRow(row).getCell(0).getSringCellValue());
        }
        workbook.close();
        fileInputStream.close();
    } catch (Exception e) {
        System.err.println("IOEXception occured while reading this file" + e.getMessage());
    }catch(Exception e){
        System.err.println("An unexpeceted error has occured" + e.getMessage());
        e.printStackTrace();
    }
    return fileNames;

        }
    }
        
    
