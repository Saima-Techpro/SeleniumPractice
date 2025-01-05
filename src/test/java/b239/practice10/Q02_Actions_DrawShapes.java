package b239.practice10;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q02_Actions_DrawShapes extends TestBase {

    /*
    Go to http://szimek.github.io/signature_pad/

    Draw the line or shape you want on the screen

    Press the clear button after drawing

    Close the page

     */
    @Test
    public void test(){

//        Go to http://szimek.github.io/signature_pad/
        driver.get("http://szimek.github.io/signature_pad/");

//        Draw the line or shape you want on the screen
        // First we need to locate the canvas/drawing pad

        WebElement board = driver.findElement(By.xpath("//canvas"));

        // Now we need actions
        Actions actions = new Actions(driver);
        actions.clickAndHold(board).perform();

        // Then we start drawing
        for (int i = 0; i < 20 ; i++) {
            actions.moveByOffset(5, 0);
        }

        for (int i = 0; i < 20 ; i++) {
            actions.moveByOffset(0, 5);
        }

        for (int i = 0; i < 20 ; i++) {
            actions.moveByOffset(-5, 0);
        }

        for (int i = 0; i < 22 ; i++) {
            actions.moveByOffset(0, -5).perform();
        }


//        Press the clear button after drawing
        WebElement clearButton = driver.findElement(By.xpath("//button[.='Clear']"));
        clearButton.click();



    }
}
