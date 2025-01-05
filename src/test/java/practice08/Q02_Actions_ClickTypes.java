package practice08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Q02_Actions_ClickTypes extends TestBase {
    /*
    Go to https://testpages.herokuapp.com/styled/events/javascript-events.html

    Click all the buttons and verify they are all clicked

     */

    @Test
    public void clickTypeTest() throws InterruptedException {
//        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
            driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
            Thread.sleep(2000);

//        Click all the buttons
        // Locate the elements first

        WebElement onblur =driver.findElement(By.id("onblur"));
        WebElement onclick =driver.findElement(By.id("onclick"));
        WebElement oncontextmenu = driver.findElement(By.id("oncontextmenu"));
        WebElement ondoubleclick =driver.findElement(By.id("ondoubleclick"));
        WebElement onfocus =driver.findElement(By.id("onfocus"));
        WebElement onkeydown =driver.findElement(By.id("onkeydown"));
        WebElement onkeyup =driver.findElement(By.id("onkeyup"));
        WebElement onkeypress =driver.findElement(By.id("onkeypress"));
        WebElement onmouseover =driver.findElement(By.id("onmouseover"));
        WebElement onmouseleave =driver.findElement(By.id("onmouseleave"));
        WebElement onmousedown =driver.findElement(By.id("onmousedown"));


        // Now click

        Actions actions = new Actions(driver);

       actions.
               click(onblur).  // clicking this button will not trigger it, we need to click somewhere else on the page
               click(onclick). // so we click the 2nd button to trigger the 1st one
               click(onclick).  // so we click the 2nd button to trigger itself
               contextClick(oncontextmenu).  // needs right click
               doubleClick(ondoubleclick).
               click(onfocus).  // just click
               click(onkeydown).sendKeys(Keys.ENTER).  // first click on the button, then press any key using Keys class
               click(onkeyup).sendKeys(Keys.SPACE).  // first click on the button, then press any key using Keys class
               click(onkeypress).sendKeys(Keys.ENTER).  // first click on the button, then press any key using Keys class
               moveToElement(onmouseover).  // just hover
               moveToElement(onmouseleave). // moveTo will not trigger onmouseleave button, we have to click the next
               click(onmousedown).  // this will trigger onmouseleave button
               click(onmousedown). // this will click on onmouseleave button itself
               build().perform();

//        Verify they are all clicked
        WebElement[] totalButton= {onblur, onclick, oncontextmenu, ondoubleclick, onfocus, onkeydown, onkeyup, onkeypress, onmouseover, onmouseleave, onmousedown};
        List<WebElement> trigger=driver.findElements(By.xpath("//p[.='Event Triggered']"));
        Assertions.assertEquals(totalButton.length,trigger.size());

        // 2nd way:
        WebElement challengeCompleted= driver.findElement(By.xpath("//p[.='Challenge Completed']"));
        String text= challengeCompleted.getText();
        System.out.println("text = " + text);

        Assertions.assertFalse(text.contains("Challenge Completed"));






    }
}
