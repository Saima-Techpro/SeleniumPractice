package b239.practice09;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q02_DragAndDropCapitals extends TestBase {
    /*
    Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    Match capitals with countries

     */

    @Test
    public void test(){

//        Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Locate the capitals and countries
        WebElement madrid=driver.findElement(By.id("box7"));
        WebElement rome=driver.findElement(By.id("box6"));
        WebElement oslo=driver.findElement(By.id("box1"));
        WebElement seoul=driver.findElement(By.id("box5"));
        WebElement copenhagen=driver.findElement(By.id("box4"));
        WebElement stockholm=driver.findElement(By.id("box2"));
        WebElement washington=driver.findElement(By.id("box3"));


        WebElement italy=driver.findElement(By.id("box106"));
        WebElement norway=driver.findElement(By.id("box101"));
        WebElement southKorea=driver.findElement(By.id("box105"));
        WebElement unitedStates=driver.findElement(By.id("box103"));
        WebElement denmark=driver.findElement(By.id("box104"));
        WebElement sweden=driver.findElement(By.id("box102"));
        WebElement spain=driver.findElement(By.id("box107"));
        

//        Match capitals with countries
        Actions actions = new Actions(driver);
        actions.dragAndDrop(madrid,spain).
                dragAndDrop(rome,italy).
                dragAndDrop(oslo, norway).
                dragAndDrop(seoul, southKorea).
                dragAndDrop(copenhagen, denmark).
                dragAndDrop(stockholm, sweden).
                dragAndDrop(washington, unitedStates).
                build().perform();


        // Assertion
        List<String> capitals2 = Arrays.asList("Rome", "Oslo", "Madrid", "Seoul", "Copenhagen", "Stockholm", "Washington");
        List<WebElement>capitals = driver.findElements(By.id("capitals"));

        boolean isDragged=false;

        for (int i=0; i<capitals.size(); i++) {

            if (!capitals.contains(capitals2.get(i))) {
                isDragged = true;

            }
        }
        assertTrue(isDragged);


    }
}
