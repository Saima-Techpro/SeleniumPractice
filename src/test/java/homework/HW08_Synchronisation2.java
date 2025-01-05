package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW08_Synchronisation2 extends TestBase {

//    Go to https://the-internet.herokuapp.com/dynamic_controls
//    Click enable Button
//    And verify the message is equal to "It's enabled!"
//    And verify the textbox is enabled (I can type in the box)
//    And click on Disable button
//    And verify the message is equal to "It's disabled!"
//    And verify the textbox is disabled (I cannot type in the box)

    //    NOTE: .isEnabled(); is used to check if an element is enabled or not

    @Test
    public void synchronizationTest2(){

//    Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//    Click enable Button
//        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
//        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled()); //IF FAILS,  EXPLICIT WAIT MUST BE USED
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement enabledMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//    And verify the message is equal to “It's enabled!”
//        String enabledMessageText=enabledMessage.getText();
//        Assertions.assertEquals(enabledMessageText,"It's enabled!");

//         OR TRY A DIFFERENT LOCATOR
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//    And verify the message is equal to "It's enabled!"
        WebElement successMessage1 = driver.findElement(By.xpath("//p[contains(text(),'enabled!')]"));
//      wait.until(ExpectedConditions.visibilityOf(successMessage1));

//      REUSABLE METHOD
        waitForVisibility(successMessage1, 10);
        Assertions.assertEquals(successMessage1.getText(), "It's enabled!");

//    And verify the textbox is enabled (I can type in the box)
        Assertions.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isEnabled());


//    And click on Disable button
        driver.findElement(By.xpath("//button[text()='Disable']")).click();

//    And verify the message is equal to "It's disabled!"
        WebElement successMessage2 = driver.findElement(By.xpath("//p[contains(text(),'disabled!')]"));
//        wait.until(ExpectedConditions.visibilityOf(successMessage2));

//      REUSABLE METHOD
        waitForVisibility(successMessage2, 10);
        Assertions.assertEquals(successMessage2.getText(), "It's disabled!");

//    And verify the textbox is disabled (I cannot type in the box)
        Assertions.assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());

    }
}
