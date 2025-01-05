package practice04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Q02_LastElementList {

    /*
    Go to  https://www.saucedemo.com/
  When
    Enter the username  as "standard_user"
  And
    Enter the password as "secret_sauce"
  And
    Click on login button
  And
    Order products by "Price (low to high)"
  Then
    Assert that last product costs $49.99, first product costs $7.99

     */

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }



    @Test
    public void test() throws InterruptedException {
//        Go to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

//        Enter the username  as "standard_user"
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        Thread.sleep(1000);

//        Enter the password as "secret_sauce"
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(1000);

//        Click on login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

//        Order products by "Price (low to high)"
       WebElement dropdown =  driver.findElement(By.xpath("//select[@class ='product_sort_container']"));

        Select select = new Select(dropdown);
        select.selectByVisibleText("Price (low to high)");
        Thread.sleep(1000);



//        Assert that last product costs $49.99, first product costs $7.99
       List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
//        System.out.println("priceList = " + priceList);
        Thread.sleep(2000);


        for (WebElement w : priceList){
            System.out.println(w.getText());
        }
        String lowestPrice = priceList.get(0).getText();
        System.out.println("lowestPrice = " + lowestPrice);
        String highestPrice = priceList.get(priceList.size()-1).getText();
        System.out.println("highestPrice = " + highestPrice);


        assertTrue( lowestPrice.contains("$7.99"));

        assertEquals("$49.99", highestPrice);




    }
}
