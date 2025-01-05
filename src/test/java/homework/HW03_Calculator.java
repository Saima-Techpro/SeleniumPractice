package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HW03_Calculator extends TestBase {

    @Test
    public void multiplyTest() throws InterruptedException {

//        Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        Thread.sleep(2000);

//        Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
        Thread.sleep(2000);

//        Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("8");
        Thread.sleep(2000);

//        Times
        WebElement options = driver.findElement(By.id("function"));
        Select selectOptions = new Select(options);
        selectOptions.selectByVisibleText("times");


//        Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("2");
        Thread.sleep(2000);

//        Click on Calculate
        driver.findElement(By.id("calculate")).click();
        Thread.sleep(2000);

//        Get the result
        String answer = driver.findElement(By.id("answer")).getText();
        System.out.println("answer = " + answer);
        Thread.sleep(2000);

//        Verify the result
        Assertions.assertEquals(answer, "16");
        Thread.sleep(2000);

//        Print the result
        System.out.println(answer);
    }



    @Test
    public void subtractTest() throws InterruptedException {
//        Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        Thread.sleep(2000);

//        Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
        Thread.sleep(2000);

//        Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("7");
        Thread.sleep(2000);

//        Minus
        WebElement options = driver.findElement(By.id("function"));
        Select selectOptions = new Select(options);
        selectOptions.selectByVisibleText("minus");
        Thread.sleep(2000);


//        Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("3");
        Thread.sleep(2000);

//        Click on Calculate
        driver.findElement(By.id("calculate")).click();
        Thread.sleep(2000);

//        Get the result
        String answer = driver.findElement(By.id("answer")).getText();
        System.out.println("answer = " + answer);
        Thread.sleep(2000);

//        Verify the result
        Assertions.assertEquals(answer, "4");
        Thread.sleep(2000);

//        Print the result
        System.out.println(answer);
    }




    @Test
    public void divisionTest() throws InterruptedException {
//        Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        Thread.sleep(2000);

//        Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
        Thread.sleep(2000);

//        Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("30");
        Thread.sleep(2000);

//        Divide
        WebElement options = driver.findElement(By.id("function"));
        Select selectOptions = new Select(options);
        selectOptions.selectByVisibleText("divide");
        Thread.sleep(2000);


//        Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("5");
        Thread.sleep(2000);

//        Click on Calculate
        driver.findElement(By.id("calculate")).click();
        Thread.sleep(2000);

//        Get the result
        String answer = driver.findElement(By.id("answer")).getText();
        System.out.println("answer = " + answer);
        Thread.sleep(2000);

//        Verify the result
        Assertions.assertEquals(answer, "6");
        Thread.sleep(2000);

//        Print the result
        System.out.println(answer);
    }
}
