package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBase {


    protected static WebDriver driver;

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeAll
    public static void setExtentReports(){
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/test-output/Reports/" + now +"extent-reports.html";

        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(reportPath);

        //****OPTIONAL : ADD Testing, Project, Tester and Device Details
        extentReports.setSystemInfo("Project Name : ", "AI");
        extentReports.setSystemInfo("Browser :", "Chrome");
        extentReports.setSystemInfo("Team Name", "Best QAs Ever");
        extentReports.setSystemInfo("SQA :", "Tanya");
        extentReports.setSystemInfo("Environment :", "Stage");

        //****OPTIONAL Adding Document Information
        extentHtmlReporter.config().setReportName("AI Test Report");
        extentHtmlReporter.config().setDocumentTitle("AI Login Test Results");

        extentReports.attachReporter(extentHtmlReporter);

        //***CREATE EXTENT TEST REPORT
        extentTest = extentReports.createTest("My First Test Case", "Team Best QAs Ever's Test Cases");

    }

    @AfterAll
    public static void flushExtentReports(){
        extentReports.flush();
    }

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    public static void openNewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }
    public static void openNewWindow(){
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public static void printData(int row, int col){
        System.out.println("============Task6===============");
        // Task 6 : Write a method that accepts 2 parameters

        // Parameter 1 = row number
        // Parameter 2 = column number
        // printData(2,3); => prints data in 2nd row 3rd column
        WebElement data= driver.findElement(By.xpath("//table[1]//tbody//tr[" + row + "]//td[" + col +"]" ));
        System.out.println(data.getText());

    }

    // DROPDOWN
    public static void dropdownSelectByIndex(By locator, int index){
        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }
    public static void dropdownSelectByIndex(String xpath,int index){
        WebElement dropdownElement = driver.findElement(By.xpath(xpath));
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }
    public static void dropdownSelectByVisibleText(WebElement dropdownElement, String text){
        Select select =new Select(dropdownElement);
        for (int i =0;i<select.getOptions().size();i++){
            if(select.getOptions().get(i).getText().equalsIgnoreCase(text)){
                select.getOptions().get(i).click();
                break;
            }
        }
    }
    public static void dropdownSelectByValue(WebElement dropdownElement, String value) {
        Select objSelect = new Select(dropdownElement);
        objSelect.selectByValue(value);
    }
    public static void dropdownSelectCustomMethod(WebElement dropdownElement,String textOfDropdown){
        List<WebElement> options = dropdownElement.findElements(By.tagName("option"));
        for (WebElement option : options){
            System.out.println(option.getText());
            if (option.getText().equals(textOfDropdown)){
                option.click();
                break;
            }
        }
    }
    public static WebElement dropdownSelectRandomly(Select select) {
        Random random = new Random();
        List<WebElement> list = select.getOptions();
        int optionIndex = 1 + random.nextInt(list.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }
    public ArrayList<String> dropdownGetSelectedOptions(WebElement dropdownElement) throws Exception {
        if (dropdownElement!=null){
            Select list = new Select(dropdownElement);
            ArrayList<WebElement> allSelectedOptions = (ArrayList<WebElement>) list.getAllSelectedOptions();
            ArrayList<String> result = new ArrayList<String>();
            for (WebElement eachSelected : allSelectedOptions){
                result.add(eachSelected.getText());
            }
            return result;
        }else {
            throw new Exception("No element is returned");
        }
    }
    //    ALERTS
    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }
    public static void alertDismiss() {
        driver.switchTo().alert().accept();
    }
    public static String alertGetText() {
        return driver.switchTo().alert().getText();
    }
    public static void alertTypeOnAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
    //    IFRAMES
    public static void switchIframeByIndex(int index){
        driver.switchTo().frame(index);
    }
    public static void switchIframeByIdOrName(String idOrName){
        driver.switchTo().frame(idOrName);
    }
    public static void switchIframeByWebElement(WebElement element){
        driver.switchTo().frame(element);
    }
    //    WINDOWS !!!
    //    Switch by page index. INDEX starts at (0) : switchNewWindowByIndex(0)
    public static void switchNewWindowByIndex(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }
    //    Switch by page title : switchNewWindowByTitle("title of the new page");
    public static void switchNewWindowByTitle(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String childWindow : driver.getWindowHandles()) {
            driver.switchTo().window(childWindow);
            if (driver.getTitle().equals(targetTitle)) {
                System.out.println("Switched to the window : "+targetTitle);
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //ACTIONS_DOUBLE CLICK : doubleClick(buttonElement)
    public static void actionsDoubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }
    //    ACTIONS_HOVER_OVER
    public static void actionsHoverOnElement(WebElement element) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }
    //    ACTIONS_SCROLL_DOWN
    public static void actionsScrollDown() {
        //        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }
    //    ACTIONS_SCROLL_UP
    public static void actionsScrollUp() {
        //        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }
    //    ACTIONS_SCROLL_RIGHT
    public static void actionsScrollRight(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
    //    ACTIONS_SCROLL_LEFT
    public static void actionsScrollLeft(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
    //    ACTIONS_DRAG_AND_DROP
    public static void actionsDragAndDrop(WebElement source, WebElement target) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source,target).perform();
    }
    //    ACTIONS_DRAG_AND_DROP_BY
    public static void actionsDragAndDrop(WebElement source, int x, int y) {
        //        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source,x,y).perform();
    }

    //    JS EXECUTOR METHODS
    /*
    click with JS
    param : WebElement
    action : clicks on the given element
     */
    public static void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }
    //    EXPLICITLY WAIT FOR ELEMENT TO BE VISIBLE, SCROLL INTO THE ELEMENT, THEN CLICK BY JS
    public static void clickWithTimeoutByJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(element,5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    /*
    scroll into specific elements
    param : WebElement
    action: scrolls into the given element
     */
    public static void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    /*
    scroll all the way down
     */
    public static void scrollAllDownJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    /*
    scroll all the way UP
     */
    public static void scrollAllUpJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    /*
     locating elements by javascript executor-normally we may not need this at all
    param : id of the element
    return WebElement
     */
    public WebElement locateElementByJS(String id){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((WebElement)js.executeScript("return document.getElementById('"+id+"')"));
    }
    /*
    getting the VALUE of elements-useful to get the values of input elements where getText() doesn't work
    param : id of the element
    locating the element and returning the value of the element
    return document.getElementById('"+id+"') -> RETURNS THE ELEMENT BY ID
    return document.getElementById('"+id+"').value -> RETURNS THE VALUE ATTRIBUTE OF THE ELEMENT
    toString() -> RETURN THE VALUE AS STRING
     */
    public static String getValueByJS(String id){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.getElementById('"+id+"').value").toString();
    }
    /*
    @param1 WebElement, @param2 String
    type the string in that input element
     */
    public static void setValueByJS(WebElement inputElement,String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",inputElement);
    }
    /*   HARD WAIT:
    @param : second
  */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*
   SELENIUM WAIT REUSABLE METHODS
    */
    //    DYNAMIC SELENIUM WAITS:
    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //        SCREENSHOTS : capture the screenshot of entire page
    public void captureScreenshotEntirePage(){
//        1. getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        2. save the image in a path with a dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir")+"/test-output/Screenshot/"+now+"image.png";
//        3. save the image in the path
        // FileUtils.copyFile(source file, destination file); // need 2 parameters
        try {
            FileUtils.copyFile(image,new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //        SCREENSHOTS : capture the screenshot of specific WebElement
    public void captureScreenshotOfElement(WebElement element){
        //        1. getScreenShotAs method to capture the screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
//        2. save the image in a path with a dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir")+"/test-output/ElementsScreenshot/"+now+"image.png";
//        3. save the image in the path
        try {
            FileUtils.copyFile(image,new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //        SCREENSHOTS : capture the screenshot of the Entire Page (for EXTENT REPORTS)
    public static String captureScreenshotEntirePageAsString(){
        //        1. getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //        2. save the image in a path with a dynamic name
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir")+"/test-output/Reports/"+now+"image.png";
        //        3. save the image in the path
        try {
            FileUtils.copyFile(image,new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //       4. return the path of the image as string. (THIS WILL BE USED TO ATTACH IN THE EXTENT REPORTS)
        return new File(filePath).getAbsolutePath();
    }


   /*
   SELENIUM VERIFICATION REUSABLE METHODS
    */
    /**
     * Verifies whether the element is displayed on page
     * fails if the element is not found or not displayed
     *
     * @param element
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue(element.isDisplayed(), "Element is not visible: " + element);
        } catch (NoSuchElementException e) {
            org.junit.jupiter.api.Assertions.fail(("Element not found: " + element));
        }
    }

    /**
     * Verifies whether the element matching the provided locator is displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementDisplayed(By by) {
        try {
            assertTrue(driver.findElement(by).isDisplayed(), "Element not visible: " + by);
        } catch (NoSuchElementException e) {
            org.junit.jupiter.api.Assertions.fail(("Element not found: " + by));
        }
    }
    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            assertFalse(driver.findElement(by).isDisplayed(),"Element should not be visible: " + by);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    /**
     * Verifies whether the element matching the provided WebElement is NOT displayed on page
     * fails if the element matching the WebElement is not found or not displayed
     * @paramWebElement
     */
    public static void verifyElementNotDisplayed(WebElement element) {
        try {
            assertFalse(element.isDisplayed(),"Element should not be visible: " + element);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void verifyElementClickable(WebElement element) {
        try {
            assertTrue(element.isEnabled(),"Element not visible: " + element);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }
    public static void verifyElementNotClickable(WebElement element) {
        try {
            assertFalse( element.isEnabled(),"Element not visible: " + element);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /*
       SELENIUM GET TEXT OF ELEMENT REUSABLE METHODS
     */
    public static String getTextWithTimeout(WebElement element, int timeout) {
        String text="";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
        return null;
    }

    /*
   SELENIUM TYPE IN AN INPUT REUSABLE METHODS
   element = input element
   text = text that you want to type
   timeout = maximum wait
     */
    public static void sendKeysWithTimeout(WebElement element,String text,int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }


}
