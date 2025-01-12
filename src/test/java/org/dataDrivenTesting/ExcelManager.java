package org.dataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {

    private static String file_path ="src/main/DataDriven.xlsx";

    public static Object[][] getData() throws IOException {
        String[][] data;
        File f1 = new File(file_path);
        FileInputStream fis = new FileInputStream(f1);

         XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        data = new String[rowCount][colCount];

        for(int i=1; i<=rowCount; i++){
            for (int j=0; j<colCount;j++){

                data[i-1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }
        wb.close();
        fis.close();
        return data;
    }}
