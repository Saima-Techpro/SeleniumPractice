package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HW11_DragAndDropPractice extends TestBase {
//        User goes to "https://jqueryui.com/accordion/"
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
//        We need to use Actions class to drag and drop


    @Test
    public void dragAndDrop() throws InterruptedException {


        driver.get("https://demoqa.com/droppable");
        Thread.sleep(5000);

        WebElement source = driver.findElement(By.id("draggable"));
        Thread.sleep(2000);
        WebElement target = driver.findElement(By.id("droppable"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }
}
