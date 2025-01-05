package practice08;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q01_Actions_Facebook extends TestBase {
    /*
        Go to https://www.facebook.com
        Click on "Create New Account"
        Fill all the boxes by using keyboard actions class
        Note: Do not use ANY locator.

     */

    @Test
    public void facebookLoginTest() throws InterruptedException {

//        Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);

//        Click on "Create New Account"
//        Create Actions object

        Actions actions = new Actions(driver);

        for (int i = 1; i < 5; i++) {
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
        actions.sendKeys(Keys.ENTER).perform();

//        Fill all the boxes by using keyboard actions class
        Faker faker = new Faker();
        Thread.sleep(2000);
        actions.sendKeys(faker.name().firstName()).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(2000);

        actions.sendKeys(faker.name().lastName()).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(2000);

        // create an email variable to send the same email again
        String email = faker.internet().emailAddress();
        actions.sendKeys(email).perform();
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);

        // because email is asked twice
        actions.sendKeys(email).perform();
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);

        // Create password variable to send the same password
        String password = faker.internet().password();
        actions.sendKeys(password).perform();
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);


        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        actions.sendKeys("12").
                sendKeys(Keys.TAB).
                sendKeys("Jul").
                sendKeys(Keys.TAB).
                sendKeys("2020").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                //sendKeys(Keys.ARROW_RIGHT).
                build().perform();


        for (int i = 1; i < 6; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }



    }
}
