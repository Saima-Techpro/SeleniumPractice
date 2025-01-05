package homework;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HW04_CountryCapitalMap_Excel {

    @Test
    public void readExcel(){

//        Store the path of the file in a string Open the file
        String path = "resources/Capitals.xlsx";

//        Open the workbook using fileinputstream
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            // First we need to open Workbook
            Workbook  workbook = WorkbookFactory.create(fileInputStream);  // to open the excel sheet
//        Open the first worksheet
           Sheet sheet1 =  workbook.getSheetAt(0); // get first sheet
//            Sheet sheet1 = workbook.getSheet("Sheet1");   // gets first sheet using name
            System.out.println("===========HOMEWORK===========");
//            HOMEWORK SOLUTION: Print country, capital key value pairs as map object()
            Map<String , String > countryCapitalMap = new HashMap<>();  // Create an empty map
            int rowCount = sheet1.getPhysicalNumberOfRows();  // returns total number of rows used without header

            for (int i = 1; i <rowCount ; i++) {
                Row row = sheet1.getRow(i);

                String countries = row.getCell(0).toString();
//            System.out.println("countries = " + countries);
                String capitals = row.getCell(1).toString();
//            System.out.println("capitals = " + capitals);

                countryCapitalMap.put(countries,capitals);
            }
            System.out.println("===========Country- Capital Map===========");
            System.out.println(countryCapitalMap);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//
//        HOMEWORK: Print country, capital key value pairs as map object
//        Clue:
//        Create an empty map
//        then use a loop to add key-value pairs in the map
//        use the pattern of indexes
//        String countries = sheet1.getRow(row number).getCell(0).toString
//        String capitals = sheet1.getRow(row number).getCell(1).toString
//        add this to the map
//        then print
//        {Greece = Athens, Canada= Ottowa,...}

    }


}
