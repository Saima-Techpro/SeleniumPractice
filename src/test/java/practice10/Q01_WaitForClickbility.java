package practice10;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q01_WaitForClickbility extends TestBase {
    // This test case is written in Gherkin Language
    /*
    Given (Precondition)
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When (action)
       Click on Ajax Loader
    And (another action)
       Click on "Click Me!" button
    Then (verification)
       Assert that button is clicked
     And (verification)
        Take screenshot after each step

     */

    @Test
    public void test(){

//        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        captureScreenshotEntirePage();

//        Click on Ajax Loader
        WebElement clickMeButton = driver.findElement(By.id("button3"));

//        Click on "Click Me!" button
        clickMeButton.click();
        captureScreenshotEntirePage();


//        Assert that button is clicked
        // Note: Before assertion, we need to locate the green "Click Me" button because there's wait issue
        WebElement greenClickMe = driver.findElement(By.xpath("//p[.='CLICK ME!']"));
        waitForClickablility(greenClickMe, 5).click();
        captureScreenshotEntirePage();

        // Now do the assertion
        WebElement successMessage = driver.findElement(By.xpath("//h4"));
        waitForVisibility(successMessage, 5);

        System.out.println(successMessage.getText());
        captureScreenshotEntirePage();

        assertEquals(successMessage.getText(), "Well Done For Waiting....!!!");
        assertTrue(successMessage.getText().contains("Well Done"));


//        Take screenshot after each step




    }




}
