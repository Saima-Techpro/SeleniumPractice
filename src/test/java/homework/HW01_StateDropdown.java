package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW01_StateDropdown extends TestBase {
//     HOMEWORK: State Test

    /*   https://testcenter.techproeducation.com/index.php?page=dropdown
            Create a new test method : statesTest in this class
            Then print the total number of states from the dropdown
            Then print all the state names
            Select 'Texas' opting using one of the method
            Assert if Texas is selected or not
            Then check is the state names are in  alphabetical order(THIS WILL FAIL B/C STATE LIST IS NOT IN ALPHABETICAL ORDER)
         */

    @Test
    public void stateDropdownTest() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        Thread.sleep(2000);

        WebElement namesOfStates = driver.findElement(By.xpath("//select[@id='state']"));
        Select select = new Select(namesOfStates);
        List<WebElement> listOfStates = select.getOptions();
        System.out.println("Total Number of States: " + listOfStates.size());

//    Then print all states from the dropdown

        for (WebElement w : listOfStates) {
            System.out.println("State name : " + w.getText());
        }

//    Select 'Texas' option using one of the methods

        select.selectByVisibleText("Texas");
//        select.selectByValue("TX");

//    Assert if 'Texas' is selected or not

        WebElement selectedState = select.getFirstSelectedOption();
        assertTrue(selectedState.getText().contains("Texas"));

//    Then check if state names are in alphabetical order or not

        List<String> originalList = new ArrayList<>();
        List<String> sortedList = new ArrayList<>();
        for (int i = 1; i < listOfStates.size(); i++) {
            originalList.add(listOfStates.get(i).getText());
            sortedList.add(listOfStates.get(i).getText());

        }
//       }
        Collections.sort(sortedList);

        String result = originalList.equals(sortedList) ? "The dropdown is in Alphabetical Order" : "The dropdown is NOT in Alphabetical Order";

        System.out.println("Result : " + result);
        System.out.println("Original List : " + originalList);
        System.out.println("Sorted List : " + sortedList);

        // OR

        //    Then check if state names are in alphabetical order or not

        List<String> allStatesInString = new ArrayList<>();

        for (WebElement w : listOfStates) {
            allStatesInString.add(w.getText());
        }
//        allStatesInString.remove(0);  // OR
        allStatesInString.removeFirst();


        List<String> sortedStates = new ArrayList<>();
        sortedStates.addAll(allStatesInString);
        Collections.sort(sortedStates);

        assertTrue(allStatesInString.equals(sortedStates));


    }
}


