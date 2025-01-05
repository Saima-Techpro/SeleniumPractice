package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW07_Synchronisation1 extends TestBase {

//    Go to https://the-internet.herokuapp.com/dynamic_controls
//    Click on remove button
//    And verify the message is equal to "It's gone!"
//    Then click on Add button
//    And verify the message is equal to "It's back!"

    @Test
    public void synchronizationTest1(){

        //    Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//    Click on remove button
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
//        OR
//        WebElement removeButton=driver.findElement(By.xpath("(//button[@type='button'])"));
//        removeButton.click();

//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//    And verify the message is equal to "It's gone!"
//      WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

//      REUSABLE METHOD
        WebElement successMessage = waitForVisibility(By.id("message"), 10);
        Assertions.assertEquals(successMessage.getText(), "It's gone!");
//        OR
//        Assertions.assertEquals("It's gone!",driver.findElement(By.xpath("//p[@id='message']")).getText());

//    Then click on Add button
        driver.findElement(By.xpath("//button[text()='Add']")).click();
//        OR
//        WebElement addButton=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
//        addButton.click();

//    And verify the message is equal to "It's back!"
//      WebElement successMessage2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

//      REUSABLE METHOD
        WebElement successMessage2 = waitForVisibility(By.id("message"), 10);
        Assertions.assertEquals(successMessage2.getText(), "It's back!");
//        OR
//        Assertions.assertEquals("It's back!",driver.findElement(By.xpath("//p[@id='message']")).getText());


    }
}
