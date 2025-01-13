package practice08;

import com.github.javafaker.Faker;
import com.myfirstseleniumproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HW_Facebook extends TestBase {
    /*
        Go to https://www.facebook.com
        Click on "Create New Account"
        Fill all the boxes by using keyboard actions class
        Note: Do not use ANY locator.

     */

    @Test
    public void facebookLoginTest() throws InterruptedException {

        Faker faker = new Faker();

        // Generate fake data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        // Go to Facebook
        driver.get("https://www.facebook.com");
        Thread.sleep(1000); // Ensure page has loaded

        // Click "Create New Account"
        Actions actions = new Actions(driver);
        for (int i = 1; i < 5; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }
        // Wait for form to load
        Thread.sleep(1000);
        // Click on New Account
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000); // Wait for the sign-up form to appear

        // Click in first Name input
        actions.sendKeys(Keys.TAB);
        Thread.sleep(1000);

        // Start filling the form with keyboard actions
        actions.sendKeys(firstName) // First Name
                .sendKeys("\t") // Tab to Last Name
                .sendKeys(lastName) // Last Name
                .sendKeys("\t")
                .perform();

        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).perform();

        // Select Birth Day using keyboard
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys("8"); // Navigate to the day
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).perform(); // Move to Birth Month

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys("March");// Navigate to the month
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).perform(); // Move to Birth Year
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys("1990");// Navigate to the year
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB); // skip Gender question mark
         // Move to Gender

        actions.sendKeys(Keys.TAB) // Tab to the "Female" radio button
                .sendKeys(Keys.SPACE) // Select Female radio button
                .perform();


        // Mobile number or email address
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        actions.sendKeys(email).perform();
        Thread.sleep(1000);

        // sending password
                actions.sendKeys("\t") // Tab to Password
                .sendKeys(password)
                .sendKeys("\t") // Tab to New Password
                .sendKeys(password)
                .perform();


        // Going to sign up button
        for (int i = 0; i < 4; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

        actions.sendKeys(Keys.ENTER).perform();


        waitFor(15);

        assertTrue(driver.getCurrentUrl().contains("confirmemail"));

    }




}
