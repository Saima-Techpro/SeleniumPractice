package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HW05_AlertWithActions extends TestBase {

    @Test
    public void alertWithActionsTest() throws InterruptedException {
//        HW:

//        ØGiven user is on the https://testcenter.techproeducation.com/index.php?page=context-menu
        driver.get("https://testcenter.techproeducation.com/index.php?page=context-menu");
        Thread.sleep(2000);

//        ØThen verify the alert message is "You selected a context menu"
//        WebElement alertBox = driver.findElement(By.id("hot-spot"));
        WebElement alertBox = driver.findElement(By.xpath("//div[@id]"));
        Actions actions = new Actions(driver);
        actions.contextClick(alertBox).perform();//contextClick()=RightClick
        Thread.sleep(2000);


//        Then verify the alert message is "You selected a context menu"
        driver.switchTo().alert();
        System.out.println("alert Text = " + alertGetText());

        Assertions.assertTrue(alertGetText().equals("You selected a context menu"));


//        Then accept the alert
        driver.switchTo().alert().accept();
    }
}
