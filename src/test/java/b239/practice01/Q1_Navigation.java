package b239.practice01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1_Navigation {
    /*
         Set Driver Path
         Create chrome driver object
         Maximize the window
         Open techproeducation home page https://techproeducation.com/
         Minimize this window
         Navigate to google home page https://www.google.com/
         Maximise the window
         Open https://www.amazon.com as a new tab or new window
         Navigate back to google
         Navigate forward to amazon
         Refresh the page
         Close/Quit the browser
         And last step : print "ALL OK" on console

     */


    @Test
    public void navigationTest() throws InterruptedException {

//        Set Driver Path
        //traditional way
//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  // windows
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver"); // MAC

//        Create chrome driver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Open techproeducation home page https://techproeducation.com/
        driver.get("https://techproeducation.com/");
        Thread.sleep(5000); // Hard Wait or Java wait

//        Minimize this window
        driver.manage().window().minimize();

//        Navigate to google home page https://www.google.com/
        driver.get("https://www.google.com/");
//        Maximise the window
        driver.manage().window().maximize();
        Thread.sleep(2000);

//        Open https://www.amazon.com as a new tab or new window
        driver.navigate().to("https://www.amazon.com");
//        Navigate back to google
        driver.navigate().back();

//        Navigate forward to amazon
        driver.navigate().forward();

//        Refresh the page
        driver.navigate().refresh();

//        Close/Quit the browser
        //driver.close(); // will close only that browser which is open
        driver.quit(); // close all open browsers

//        And last step : print "ALL OK" on console
        System.out.println("ALL OK");




    }

}
