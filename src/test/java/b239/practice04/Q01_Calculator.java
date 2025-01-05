package b239.practice04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Q01_Calculator {

    WebDriver driver;
    /*

    Create chrome driver by using @BeforeEach annotation and WebDriverManager
    Navigate to  https://testpages.herokuapp.com/styled/index.html
    Click on  Calculator under Micro Apps
    Type any number in the first input
    Type any number in the second input
    Click on 'times' option from the dropdown
    Click on Calculate
    Get the result
    Verify the result
    Print the result
    Close the browser by using @AfterEach annotation

     */

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);  // Optional
        driver.close();
    }

    @Test
    public void multiply() throws InterruptedException {
        //        Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

//        Click on  Calculator under Micro Apps
        WebElement calculator = driver.findElement(By.id("calculatetest"));
        calculator.click();
        Thread.sleep(2000);

        assertTrue(driver.getCurrentUrl().contains("calculator"));

//        Type any number in the first input
        WebElement number1 = driver.findElement(By.id("number1"));
        number1.sendKeys("7");
//        Type any number in the second input
        WebElement number2 = driver.findElement(By.id("number2"));
        number2.sendKeys("8");
        Thread.sleep(2000);

//        Click on 'times' option from the dropdown
        WebElement dropdown = driver.findElement(By.id("function"));

        Select select = new Select(dropdown);
        select.selectByIndex(1);

//        Click on Calculate
        WebElement calculateButton = driver.findElement(By.id("calculate"));
        calculateButton.click();
        Thread.sleep(2000);
//        Get the result
        WebElement result = driver.findElement(By.id("answer"));
        String resultText = result.getText();

//        Verify the result
        assertEquals("56", resultText);

//        Print the result
        System.out.println("resultText = " + resultText);



    }


}
