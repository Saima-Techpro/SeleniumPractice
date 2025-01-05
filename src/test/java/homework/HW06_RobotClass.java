package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class HW06_RobotClass extends TestBase {
    /* HW:
    Given user goes to https://www.grammarly.com/plagiarism-checker
    Then click upload file
    Then selects a document  (any word document)
    And upload that file
    Then Verify that file is uploaded

     */
    @Test
    public void fileUploadTestRobot() throws AWTException {
//        driver.get("https://demoqa.com/upload-download");
        driver.get("https://www.grammarly.com/plagiarism-checker");

//        Locate the uploadFile element

        WebElement uploadFile = driver.findElement(By.xpath("//div[@id='sectionGrammarCheck_4VB8kepvT7ciShVSz6rHX']//span[@class='iconWrapper_PbRSndwM']"));
        uploadFile.click();

        String pathOfFile = System.getProperty("user.home") + "/Desktop/samplefile.docx";//mac
//        String pathOfFlower = System.getProperty("user.home") + "\\Desktop\\flower.jpeg";//windows
        uploadFilePath(pathOfFile);  // Using  REUSABLE METHOD WITHIN THE SAME CLASS

//        Then Verify that file is uploaded

        Assertions.assertTrue(driver.findElement(By.name("userText")).getText().contains("Hello World!!!"));
    }

    // REUSABLE METHOD WITHIN THE SAME CLASS
//    public static void uploadFilePath(String filePath){
//        try{
//            waitFor(3);
//            StringSelection stringSelection = new StringSelection(filePath);
//            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
//            Robot robot = new Robot();
//            //pressing ctrl+v
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_C);
//            robot.keyRelease(KeyEvent.VK_C);
//
//            waitFor(3);
//            //releasing ctrl+v
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            waitFor(3);
//            System.out.println("PASSED");
//            //pressing enter
//            waitFor(3);
//            robot.keyPress(KeyEvent.VK_ENTER);
//            //releasing enter
//            robot.keyRelease(KeyEvent.VK_ENTER);
//            waitFor(3);
//            System.out.println("ENTER");
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }


    // REUSABLE METHOD from TestBase

    @Test
    public void robotTest(){

//        driver.get("https://demoqa.com/upload-download");
        driver.get("https://www.grammarly.com/plagiarism-checker");
//        Locate the uploadFile element

        WebElement uploadFile = driver.findElement(By.xpath("//div[@id='sectionGrammarCheck_4VB8kepvT7ciShVSz6rHX']//span[@class='iconWrapper_PbRSndwM']"));
        uploadFile.click();

        String pathOfFile = System.getProperty("user.home") + "/Desktop/text.txt";//mac
//        String pathOfFlower = System.getProperty("user.home") + "\\Desktop\\flower.jpeg";//windows

        uploadFile(pathOfFile);  // REUSABLE METHOD from TestBase
//        And upload that file
//        Then Verify that file is uploaded

        Assertions.assertTrue(driver.findElement(By.name("userText")).getText().contains("Hello World!!!"));


    }


}
