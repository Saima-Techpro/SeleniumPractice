package practice07;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q01_Excel_Earnings {
    /*
    Given
        Save EarningList.xlsx file into your project
    When
        In the third column, write the row numbers according to the earnings amount(Natural Order).
    Then
        Assert that row number of Wednesday is 1

     */

    @Test
    public void test() throws IOException {

        //  Save EarningList.xlsx file into your project  = DONE :)

        // How to reach to Excel sheet?
        String path = "resources/EarningList.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

         Workbook workbook = WorkbookFactory.create(fileInputStream);
//         Sheet sheet = workbook.getSheetAt(0);
         Sheet sheet1 = workbook.getSheet("Sheet1");
        System.out.println( sheet1.getRow(1).getCell(1)); // 512.0

        System.out.println("Last Row Num  = " + sheet1.getLastRowNum());

        // Create an empty list to store all salary data
        List<Double> earnings = new ArrayList<>();

        for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
            earnings.add(Double.valueOf(sheet1.getRow(i).getCell(1).toString())) ;
            
        }
        System.out.println("earnings = " + earnings);  // earnings = [512.0, 205.0, 635.0, 344.0, 489.0, 0.0, 0.0]

        // Logic: We will keep the original earnings list for comparison purpose.
        // Create another List, assign this data to the new list
        // sort the newList and then compare each data


        List<Double> newList = new ArrayList<>(earnings); // [512.0, 205.0, 635.0, 344.0, 489.0, 0.0, 0.0]
        System.out.println("newList = " + newList);

        Collections.sort(newList);  // put the new list into ascending order

        System.out.println(" ordered List = " + newList); // [0.0, 0.0, 205.0, 344.0, 489.0, 512.0, 635.0]

        Collections.reverse(newList); // itt will reverse the list in descending order

        System.out.println("reversed List = " + newList); // reversed List =  [635.0, 512.0, 489.0, 344.0, 205.0, 0.0, 0.0]

        // In the third column, write the row numbers according to the earnings amount(Natural Order).
        // To write on the Excel sheet, we need to compare the data in each list, and assign number 1 to the highest salary, number 2 to the second .... 

        // earnings = [512.0, 205.0, 635.0, 344.0, 489.0, 0.0, 0.0]


        // reversed List =  [635.0, 512.0, 489.0, 344.0, 205.0, 0.0, 0.0]

        for (int i = 0; i < earnings.size(); i++) {

            for (int j = 0; j < newList.size(); j++) {
                if (earnings.get(i) == newList.get(j)){
                    sheet1.getRow(i+1).createCell(2).setCellValue(j+1);
                }

            }
        }

        // To write on to Excel sheet, we must use FileOutputStream
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        
        // Assert that row number of Wednesday is 1
        String salaryOrder = sheet1.getRow(3).getCell(2).toString();
        System.out.println("salaryOrder = " + salaryOrder);

        assertEquals("1.0", salaryOrder);


    }
}
