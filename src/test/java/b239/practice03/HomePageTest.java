package b239.practice03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

//    @AfterEach
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(2000);  // Optional
//        driver.close();
//    }


    @Test
    public void test() throws InterruptedException {
        //  1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        WebElement homePageLogo= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        assertTrue(homePageLogo.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement loginButton= driver.findElement(By.xpath("//a[.=' Signup / Login']"));
        loginButton.click();
        //5. Verify 'Login to your account' is visible
//WebElement loginInYourAccount= driver.findElement(By.xpath("//h2"));
//Assertions.assertTrue(loginInYourAccount.isDisplayed());
        //6. Enter correct email address and password
        WebElement email= driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("af_af@gmail.com");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("af2023AF!");
        //7. Click 'login' button
        WebElement login= driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        Thread.sleep(1000);
        login.click();
        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInAsUsername= driver.findElement(By.partialLinkText("Affaaf"));
        assertTrue(loggedInAsUsername.isDisplayed());
        //9. Click 'Delete Account' button
        Thread.sleep(2000);
        WebElement deleteAccount= driver.findElement(By.xpath("//a[.=' Delete Account']"));
        deleteAccount.click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDeleted= driver.findElement(By.xpath("//h2[.='Account Deleted!']"));
        assertTrue(accountDeleted.getText().contains("ACCOUNT DELETED!"));
        Thread.sleep(2000);

        // Now click on home icon to navigate back to the homepage (because you're still at the account page)

        WebElement homeIcon = driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        homeIcon.click();
        Thread.sleep(2000);

        WebElement homePageLogo1= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        assertTrue(homePageLogo1.isDisplayed());


    }
}
