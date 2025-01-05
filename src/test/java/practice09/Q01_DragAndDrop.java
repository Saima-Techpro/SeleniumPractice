package practice09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q01_DragAndDrop extends TestBase {

    /*
    Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below
    Then
        Verify they are dropped.
     */

    @Test
    public void dragAndDropTest(){

//        Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

//        Drag orange elements on proper boxes below

        // Locate orange elements
        WebElement firstAmount = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement secondAmount = driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement sales = driver.findElement(By.id("credit1"));

        // Locate the target elements
        WebElement debitAmount = driver.findElement(By.id("amt7"));
        WebElement creditAmount = driver.findElement(By.id("amt8"));
        WebElement debitAccount = driver.findElement(By.id("bank"));
        WebElement creditAccount = driver.findElement(By.id("loan"));

        // Now drag and drop orange elements to their target places

        Actions actions = new Actions(driver);
        actions.
                dragAndDrop(firstAmount, debitAmount).
                dragAndDrop(secondAmount, creditAmount).
                dragAndDrop(bank, debitAccount).
                dragAndDrop(sales, creditAccount).
                build().perform();


//        Verify they are dropped
        WebElement successMessage = driver.findElement(By.linkText("Perfect!"));
        assertTrue(successMessage.getText().contains("Perfect!"));


    }


    // 2nd way: Ozge's solution
    @Test
    public void test(){
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        Actions act=new Actions(driver);
        WebElement bank=driver.findElement(By.xpath("//a[.=' BANK ']"));
        WebElement drop1=driver.findElement(By.id("bank"));
        act.dragAndDrop(bank,drop1).perform();

        WebElement fiveThousand=driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement drop2=driver.findElement(By.id("amt7"));
        act.dragAndDrop(fiveThousand,drop2).perform();
        WebElement sales= driver.findElement(By.xpath("//a[.=' SALES ']"));

        WebElement drop3= driver.findElement(By.id("loan"));
        act.dragAndDrop(sales,drop3).perform();
        WebElement fiveThousand2=driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));
        WebElement drop4=driver.findElement(By.id("amt8"));
        act.dragAndDrop(fiveThousand2,drop4).perform();
        WebElement perfect=driver.findElement(By.xpath("//a[.='Perfect!']"));
        Assertions.assertTrue(perfect.isDisplayed());

    }



}
