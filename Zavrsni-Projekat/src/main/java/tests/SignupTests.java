package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{

   @Test(priority = 10)
    public void visitsTheSignupPage(){

   navPage.getSignUpLink().click();
       Assert.assertTrue(
               driver.getCurrentUrl().contains("/signup"),
               "Url does not contain '/signup'");

   }
   @Test(priority = 20)
    public void checksInputTypes(){

       navPage.getSignUpLink().click();
       Assert.assertTrue(signupPage.getEmailField().getAttribute("type")
                       .contains("email"),
               "Field for email input does not contain value 'email'");
       Assert.assertTrue(signupPage.getPasswordField().getAttribute("type")
                       .contains("password"),
               "Field for password input does not contain value 'password'");
       Assert.assertTrue(signupPage.getConfirmPasswordField().getAttribute("type")
                       .contains("password"),
               "Field for confirm email input does not contain value 'password'");

   }
   @Test(priority = 30)
    public void displaysErrorsWhenUserAlreadyExists() throws InterruptedException {

       String name = "Another User";
       String email = "admin@admin.com";
       String password = "12345";

       navPage.getSignUpLink().click();
       Thread.sleep(3000);
       Assert.assertTrue(
               driver.getCurrentUrl().contains("/signup"),
               "Url does not contain '/signup'");
       signupPage.getNameField().sendKeys(name);
       signupPage.getEmailField().sendKeys(email);
       signupPage.getPasswordField().sendKeys(password);
       signupPage.getConfirmPasswordField().sendKeys(password);
       signupPage.getSignMeUpButton().click();
       messagePopUpPage.waitForPopUpToBeInvisible();
      Assert.assertEquals(messagePopUpPage.getTextMesage().getText(),
              "E-mail already exists",
              "The text in the popup element does not contain the expected text");
      Thread.sleep(3000);
      Assert.assertTrue(driver.getCurrentUrl().contains("signup"),
              "Page url does not contain /signup");
   }
   @Test(priority = 40)
    public void signup() throws InterruptedException {
       String name = "Milos Milutinovic";
       String emailTemplate = "milllutin@gmail.com";
       String password = "12345";

       navPage.getSignUpLink().click();
       signupPage.getNameField().sendKeys(name);
       signupPage.getEmailField().sendKeys(emailTemplate);
       signupPage.getPasswordField().sendKeys(password);
       signupPage.getConfirmPasswordField().sendKeys(password);
       signupPage.getSignMeUpButton().click();
       Thread.sleep(3000);



      Assert.assertEquals(messagePopUpPage.getVerifyPopUp().getText(),
               "IMPORTANT: Verify your account",
               "The message does not show");

       messagePopUpPage.getVerifyPopUpCloseButton().click();
       navPage.getLogoutButton().click();

   }



}

//    Test #1: Visits the signup page
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Verifikovati da se u url-u stranice javlja /signup ruta
//
//
//        Test #2: Checks input types
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Verifikovati da polje za unos emaila za atribut type ima vrednost email
//        Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//        Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
//
//
//
//        Test #3: Displays errors when user already exists
//        Podaci:
//        name: Another User
//        email: admin@admin.com
//      password: 12345
//        confirm password: 12345
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Verifikovati da se u url-u stranice javlja /signup ruta
//        Popuniti formu za registraciju podacima
//        Klik na sign up dugme
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da greska sadrzi poruku E-mail already exists
//        Verifikovati da se u url-u stranice javlja /signup ruta
//
//        Test #4: Signup
//        Podaci:
//        name: Ime i prezime polaznika
//        email template: ime.prezime@itbootcamp.rs
//      password: 12345
//        confirm password: 12345
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Popuniti formu podacima za registraciju
//        Klik na sign up dugme
//        Ucitati stranicu /home
//        Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
//        Kliknuti na Close dugme iz dijaloga
//        Kliknuti na logout
