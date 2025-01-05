package b239.practice10;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q03_WebTables extends TestBase {
    /*
    We will make a roof of 5% of the height of the earliest (oldest) built tower.
    Find how many meters we will build.

    Given
        Go to https://www.techlistic.com/p/demo-selenium-practice.html
    When
        Put all built years into a list
    And
        Calculate min year
    And
        Put all heights into a list
    And
        Calculate the height of the oldest build
    Then
        Assert that building height is 25.45 meters
     */

    @Test
    public void test(){
//        Go to https://www.techlistic.com/p/demo-selenium-practice.html
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

//        Put all built years into a list
        List<WebElement> builtYears = driver.findElements(By.xpath("(//tbody)[2]/tr/td[4]"));
        builtYears.forEach(t-> System.out.print(t.getText() + " , "));

//        Calculate min year
        int minYear = Integer.MAX_VALUE;  // we assume a value as minimum and then we  will use this for comparison
        // System.out.println(minYear);

        for (WebElement  w : builtYears){
            if (Integer.parseInt(w.getText()) < minYear){
                minYear = Integer.parseInt(w.getText());
            }
        }

        System.out.println(minYear); // 2004
        // Now we find the index of this minYear so that we can have access to the whole row

        int minYearInd = 0;

        for (int i = 0; i < builtYears.size() ; i++) {
            if (Integer.parseInt(builtYears.get(i).getText()) == minYear){
               minYearInd = i;
            }
        }

        System.out.println("minYearInd = " + minYearInd);

        // HW
//        Put all heights into a list

//        Calculate the height of the oldest build

//        Assert that building height is 25.45 meters

    }
}
