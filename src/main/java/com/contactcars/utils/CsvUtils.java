package com.contactcars.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CsvUtils {

    public static XSSFWorkbook workbook;
    public static Sheet sheet1;
    public static Sheet sheet2;


    // Loading properties and credentials files
    public CsvUtils() throws IOException {
        File credentials = new File("D:\\Website Variables.xlsx");
        FileInputStream fis = new FileInputStream(credentials);
        workbook = new XSSFWorkbook(fis);
        sheet1 = workbook.getSheetAt(0);
        sheet2 = workbook.getSheetAt(1);
    }

    // Get the variables from the Excel sheet 1 regardless of their position
    public static String getVariableValueFromSheet1(String variableKey) {
        int lastColumn = sheet1.getLastRowNum();
        for (int i = 0; i <= lastColumn; i++) {
            if (variableKey.equals(sheet1.getRow(i).getCell(0).toString())) {
                return sheet1.getRow(i).getCell(1).toString();
            }
        }
        return null;
    }

    // Get the variables from the Excel sheet 2 regardless of their position
    public static String getVariableValueFromSheet2(String variableKey) {
        int lastColumn = sheet2.getLastRowNum();
        for (int i = 0; i <= lastColumn; i++) {
            if (variableKey.equals(sheet2.getRow(i).getCell(0).toString())) {
                return sheet2.getRow(i).getCell(1).toString();
            }
        }
        return null;
    }

}
