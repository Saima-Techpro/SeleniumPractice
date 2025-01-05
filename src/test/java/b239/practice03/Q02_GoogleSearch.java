package b239.practice03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02_GoogleSearch {

    WebDriver driver;

    /*
    Create driver and go to http://www.google.com in the BeforeEach method

     With 3 different test methods:
      -Type "Desktop" in the search box and search it
      -Type "Smartphone" in the search box and search it
      -Type "Laptop" in the search box and search it
     NOTE:
     Click on tool option
     Locate the result on the right hand side
     Print the result numbers in AfterEach method
     Close driver with AfterEach method

     */

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://www.google.com");
    }

    @AfterEach
    public void tearDown() throws InterruptedException {

//        Click on tool option
        WebElement toolOption = driver.findElement(By.id("hdtb-tls"));
        Thread.sleep(2000);
        toolOption.click();

//        Locate the result on the right hand side
        String result = driver.findElement(By.id("result-stats")).getText();

//        Print the result numbers in AfterEach method
        System.out.println("result = " + result);  // About 11,100,000,000 results
        Thread.sleep(2000);

        String numInResult = result.split(" ")[1];
        System.out.println("numInResult = " + numInResult);


        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

//        -Type "Desktop" in the search box and search it

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Desktop");
        //1 way:
        searchBox.submit();
        Thread.sleep(2000);
        // 2nd way => Use Keys class

    }


    @Test
    public void test2() throws InterruptedException {

//        -Type "Smartphone" in the search box and search it

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Smartphone");
        //1 way:
        searchBox.submit();
        Thread.sleep(2000);
        // 2nd way => Use Keys class

    }

    @Test
    public void test3() throws InterruptedException {

//        -Type "Laptop" in the search box and search it

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Laptop");
        //1 way:
        searchBox.submit();
        Thread.sleep(2000);
        // 2nd way => Use Keys class

    }


}
