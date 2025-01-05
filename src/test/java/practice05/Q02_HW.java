package practice05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class Q02_HW extends TestBase {
    /*

    //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
    //Click on "click me" button
    //Verify that "Event Triggered"

     */


    @Test
    public void test1() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        //Click on "click me" button
        WebElement clickMe = driver.findElement(By.id("growbutton"));
       Thread.sleep(5000);  // Hard wait that will allow the button to grow fully before being clicked
        clickMe.click();

        //Verify that "Event Triggered"
        WebElement eventTriggered = driver.findElement(By.id("growbuttonstatus"));
        Assertions.assertEquals("Event Triggered", eventTriggered.getText());


    }


      /*
  Given
      Go to http://webdriveruniversity.com/To-Do-List/index.html
  When
      Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
  And
      Strikethrough all todos.
  And
      Delete all todos.
  Then
      Assert that all todos deleted.
  */

    @Test
    public void test2() throws InterruptedException {
        //Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        //Using loop to add toDos as a list
        WebElement addToDO = driver.findElement(By.xpath("//input[@type='text']"));
        List<String> toDos = Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep");

        int size = toDos.size();

        for(int i = 0; i <= size-1; i++){
            addToDO.sendKeys(toDos.get(i), Keys.ENTER);
            Thread.sleep(1000);
        }

        //Strikethrough all todos
        List<WebElement> allToDos = driver.findElements(By.xpath("//ul/li"));

        for(WebElement w: allToDos){
            if(!w.isSelected()){
                w.click();
            }
        }

        // Delete all todos
        List <WebElement> completedBins = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        for(WebElement each : completedBins){
            if(!each.isSelected()){
                each.click();
            }
            Thread.sleep(2000);
        }

        //Assert that all todos deleted
        List <WebElement> remainingToDOs = driver.findElements(By.xpath("//ul/li"));
        System.out.println("Remaining To Do List: " + remainingToDOs);
        Assertions.assertTrue(remainingToDOs.isEmpty());

    }



}
