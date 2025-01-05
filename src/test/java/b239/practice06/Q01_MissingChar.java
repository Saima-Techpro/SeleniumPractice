package b239.practice06;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q01_MissingChar extends TestBase {
    /*

    The paper on which your password is written has become wet, and the last character of your password
    cannot be read.

Write a code that randomly generates a solution for this issue.
App: https://testcenter.techproeducation.com/index.php?page=form-authentication

     */

    @Test
    public void test() throws InterruptedException {

        // We want the driver to try as many times as it needs to find the right letter/character,
        // we need to use loop

        int counter =0; // optional => to see how many attempts driver had to do

        while(true){ // create an infinite loop so that we can break it with an if statement when successMessage is found
            counter++;
            // Go to https://testcenter.techproeducation.com/index.php?page=form-authentication
            driver.get("https://testcenter.techproeducation.com/index.php?page=form-authentication");

            // enter the username
            WebElement userName = driver.findElement(By.id("exampleInputEmail1"));
            userName.sendKeys("techproed");
            Thread.sleep(1000);

            // enter the password
            WebElement password = driver.findElement(By.id("exampleInputPassword1"));

            String missingChar = Faker.instance().lorem().characters(1);
            System.out.println("missingChar = " + missingChar);

            password.sendKeys("SuperSecretPasswor" + missingChar);

            Thread.sleep(1000);

            // click on submit button
            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

            submitButton.click();
            Thread.sleep(1000);

            // verify you logged in successfully
            // "You logged into a secure area!"

            WebElement successMessage = null;

          try{
              successMessage = driver.findElement(By.xpath("//div[@role='alert']"));
              assertTrue(successMessage.getText().contains("You logged into a secure area!"));

              boolean isSuccess = successMessage.getText().contains("You logged into a secure area!");

              if (isSuccess){
                  System.out.println("number of attempts: "+ counter);
                  break;
              }
          }catch (Exception ignored){

          }


        }

        /*

        student's solution:
        //           List<String>listLetter=new ArrayList<>();
//           if (!listLetter.contains(missingChar)){
//               listLetter.add(missingChar);
//               for (String  w : listLetter){
//                   password.sendKeys("SuperSecretPasswor" + w);
//                   System.out.println("missingChar = " + w);
//               }
//           }
            Set<String> list=new HashSet<>();
           list.add(missingChar);
           for (String w : list){
               password.sendKeys("SuperSecretPasswor" + w);
               System.out.println("missingChar = " + w);
           }
         */





    }




}
