package b239.practice04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Q03_AmazonDropDown extends TestBase {
    /*
       Go to https://amazon.com
       Print all the options in the 'Departments' dropdown on the left side of the search box
       Search for each first five options and print titles

     */


    @Test
    public void test() throws InterruptedException {

//        Go to https://amazon.com
        driver.get("https://amazon.com");
        // driver.navigate().refresh(); // refreshing the page can get rid of amazon captcha USUALLY, BUT NOY ALWAYS

        // OR

        WebElement tryDiffrnt = driver.findElement(By.linkText("Try different image"));
        tryDiffrnt.click();



//        Print all the options in the 'Departments' dropdown on the left side of the search box
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Thread.sleep(2000);

        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();

        for (WebElement w : options){
            System.out.println(w.getText());
        }

        System.out.println("======== Searching for first five elements ======");
//        Search for each first five options and verify titles

        for (int i = 1; i < 6; i++) {
            //System.out.println(options.get(i).getText()); // options element has become stale, so we need to comment it out or remove it

            // In order to avoid StaleElement Exception, we need to refresh our element that we located earlier

            String eachOption = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions().get(i).getText();

            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(eachOption, Keys.ENTER);

            System.out.println(driver.getTitle());
            driver.navigate().back(); // to go back to All Department / main page
        }


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://amazon.com");
        Thread.sleep(3000);
        if (driver.getTitle().contains("Spend less")) {
            System.out.println("Captcha is resolved");
        } else {
            driver.navigate().refresh();

            WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            Select options = new Select(dropDown);

            List<WebElement> list = options.getOptions().subList(1, 6);
            for (WebElement w : list) {
                System.out.println(w.getText());

            }

            System.out.println("======== First five departments ============");

//        Search for each first five options and print titles

            for (int i = 1; i < 6; i++) {
                //System.out.println(options.get(i).getText()); // options element has become stale, so we need to comment it out or remove it

                // In order to avoid StaleElement Exception, we need to refresh our element that we located earlier

                String eachOption = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions().get(i).getText();

                driver.findElement(By.id("twotabsearchtextbox")).sendKeys(eachOption, Keys.ENTER);

                System.out.println(driver.getTitle());
                driver.navigate().back(); // to go back to All Department / main page
            }
        }
    }



}
