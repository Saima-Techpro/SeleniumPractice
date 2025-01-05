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
import java.util.List;

public class Q03_AmazonDropDown {
    /*
       Go to https://amazon.com
       Print all the options in the 'Departments' dropdown on the left side of the search box
       Search for each first five options and print titles

     */

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
//        Search for each first five options and print titles

        int counter = 0;

        for (WebElement w : options){
            System.out.println(w.getText());
            counter++;
            if (counter ==5 ){
                break;
            }

        }


    }







}
