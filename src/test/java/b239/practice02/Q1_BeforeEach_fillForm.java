package b239.practice02;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q1_BeforeEach_fillForm {

    /*
Create chrome driver by using @BeforeEach annotation and WebDriverManager
Go to url : http://www.gmibank.com/
Click on 'User Icon’
Click on 'Register’
Enter SSN
Enter First Name
Enter Last Name
Enter Address
Enter Phone Number
Enter Username
Enter Email
Enter New password
Enter New password confirmation
Click on Register button
Assert that user registered
Close the browser by using @AfterEach annotation

     */

    WebDriver driver;  // class variable

    Faker faker = new Faker();

    //        Create chrome driver by using @BeforeEach annotation and WebDriverManager

    @BeforeEach
    public void setUp(){
        // WebDriverManager was used to set up the system for drivers
        // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Implicit wait only waits when it's needed

    }


    @Test
    public void formTest() throws InterruptedException {

//        Go to url : http://www.gmibank.com/
        driver.get("http://www.gmibank.com/");

//        Click on 'User Icon’
         WebElement userIcon =  driver.findElement(By.id("account-menu"));
         userIcon.click();
         Thread.sleep(2000);


//        Click on 'Register’
        WebElement registerOption = driver.findElement(By.linkText("Register"));
        registerOption.click();
        Thread.sleep(2000);

        // Verify using if statement

        String url = driver.getCurrentUrl();
        if (url.contains("register")){
            System.out.println("Register option is clicked successfully!");
        } else {
            System.out.println("Register option is not clicked successfully!");
        }

        // If statements can NOT be used for Assertions

        assertTrue(url.contains("register"));  // Hard Assertion

//        Enter SSN
        WebElement ssn = driver.findElement(By.id("ssn"));
        ssn.sendKeys("298-93-7728");

//        Enter First Name
//        driver.findElement(By.id("firstname")).sendKeys("Tom");
       WebElement firstName =  driver.findElement(By.id("firstname"));
       firstName.sendKeys(faker.name().firstName());

        Thread.sleep(1000);
//        Enter Last Name
        driver.findElement(By.id("lastname")).sendKeys("Hanks");
        Thread.sleep(1000);

//        Enter Address
        WebElement address = driver.findElement(By.xpath("//input[@name = 'address']"));
        address.sendKeys( new Faker().address().fullAddress()); // this way should only be used if you don't need faker class for all input values

//        Enter Phone Number
        WebElement phoneNum = driver.findElement(By.xpath("//input[@name = 'mobilephone']"));
        phoneNum.sendKeys(faker.phoneNumber().cellPhone());
//        Enter Username
//        driver.findElement(By.cssSelector("[id = 'username']"));  OR
        WebElement userName = driver.findElement(By.cssSelector("#username"));
        userName.sendKeys(faker.name().username());

//        Enter Email
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys(faker.internet().emailAddress());

//        Enter New password
       WebElement newPassword =  driver.findElement(By.xpath("//*[@name='firstPassword']"));
       newPassword.sendKeys("User_2024");

//        Enter New password confirmation
        WebElement secondPassword =  driver.findElement(By.xpath("//*[@name='secondPassword']"));
        secondPassword.sendKeys("User_2024");

//        Click on Register button
//        WebElement registerButton = driver.findElement(By.id("register-submit"));
        WebElement registerButton = driver.findElement(By.xpath("(//span[.='Register'])[2]"));
        registerButton.click();
        Thread.sleep(2000);

//        Assert that user registered
        WebElement successMessage = driver.findElement(By.xpath("//div[@role='alert']"));

        assertTrue(successMessage.isDisplayed());

//        Close the browser by using @AfterEach annotation

    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000); // Hard Wait
        driver.close();

    }

}
