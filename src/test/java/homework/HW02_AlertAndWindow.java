package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW02_AlertAndWindow extends TestBase {
    /* When Navigate to https://testpages.herokuapp.com/styled/windows-test.html

     When Click on "Alerts In A New Window From JavaScript"
     And Switch to new window
     And Click on "Show alert box" button
     And Accept alert
     And Click on "Show confirm box" button
     And Cancel alert
     Then Assert that alert is cancelled
     When Click on "Show prompt box" button
     And Send "Hello World!" to the alert
     Then Assert that "Hello World!" is sent

     */
    @Test
    public void alertAndWindowTest() throws InterruptedException {
//        When Navigate to https://testpages.herokuapp.com/styled/windows-test.html
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        Thread.sleep(2000);

//        When Click on "Alerts In A New Window From JavaScript"
        driver.findElement(By.cssSelector("#goalerts")).click();
        Thread.sleep(2000);

//        And Switch to new window
        String firstWindowHandle = driver.getWindowHandle();
        Set<String> allWindowsHandles = driver.getWindowHandles();
        for (String w : allWindowsHandles) {
            if(!w.equals(firstWindowHandle)){
                driver.switchTo().window(w);
            }
        }
        Thread.sleep(2000);

//        And Click on "Show alert box" button
        driver.findElement(By.xpath("//input[@id='alertexamples']")).click();
        Thread.sleep(2000);

//        And Accept alert
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

//        And Click on "Show confirm box" button
        driver.findElement(By.xpath("//input[@id='confirmexample']")).click();
        Thread.sleep(2000);

//        And Cancel alert
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

//        Then Assert that alert is cancelled
        String result = driver.findElement(By.xpath("//p[@id='confirmreturn']")).getText();
        assertTrue(result.equals("false"));
        Thread.sleep(2000);

//        When Click on "Show prompt box" button

        driver.findElement(By.id("promptexample")).click();
        Thread.sleep(2000);

//        And Send "Hello World!" to the alert
        driver.switchTo().alert().sendKeys("Hello World!");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

//        Then Assert that "Hello World!" is sent
        assertTrue(driver.findElement(By.id("promptreturn")).getText().contains("Hello World!"));

    }


}
