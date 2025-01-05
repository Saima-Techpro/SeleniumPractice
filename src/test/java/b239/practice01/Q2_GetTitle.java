package b239.practice01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2_GetTitle {
    /*
    Create chrome driver object
    Maximize the window
    Open google home page https://www.google.com/
    Wait for 3 seconds
    Go to the https://techproeducation.com/
    Get the title and URL of the page
    Check if the title contains the word "Bootcamps" print console "Title contains Bootcamps" or "Title does not contain Bootcamps”
    Check if the URL contains the word "techpro" print console "URL contains techpro" or "URL does not contain techpro”
    Then go to https://medunna.com/
    Get the title and check if it contains the word "MEDUNNA" and print "Title contains MEDUNNA" or "Title does not contain MEDUNNA”
    Navigate Back to the previous webpage
    Refresh the page
    Navigate to forward
    Wait for 3 seconds
    Close the browser
     */

    @Test
    public void getTitleTest() throws InterruptedException {

//        Create chrome driver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

//        Wait for 3 seconds
        Thread.sleep(3000); // Java wait

//        Go to the https://techproeducation.com/
        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);

//        Get the title and URL of the page
        String title = driver.getTitle();
        System.out.println("title = " + title);

        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);

//        Check if the title contains the word "Bootcamps" print "Title contains Bootcamps" or "Title does not contain Bootcamps”
        if (title.contains("Bootcamps")){
            System.out.println("Title contains Bootcamps");
        } else {
            System.out.println( "Title does not contain Bootcamps" );
        }

//        Check if the URL contains the word "techpro" print "URL contains techpro" or "URL does not contain techpro”
        if (url.contains("techpro")){
            System.out.println("URL contains techpro");
        } else {
            System.out.println("URL does not contain techpro");
        }

//        Then go to https://medunna.com/
        driver.navigate().to("https://medunna.com/");

//        Get the title and check if it contains the word "MEDUNNA" and print "Title contains MEDUNNA" or "Title does not contain MEDUNNA”
        String medunnaTitle = driver.getTitle();
        System.out.println("medunnaTitle = " + medunnaTitle);

//        Navigate Back to the previous webpage
        driver.navigate().back();

//        Refresh the page
        driver.navigate().refresh();

//        Navigate to forward
        driver.navigate().forward();

//        Wait for 3 seconds
        Thread.sleep(3000);

//        Close the browser
        driver.quit();


    }
}
