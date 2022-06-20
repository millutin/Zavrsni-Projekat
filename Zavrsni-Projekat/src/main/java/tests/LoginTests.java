package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BasicTest {

    @Test(priority = 10)
    public void visitsTheLoginPage() throws InterruptedException {

        driver.get(baseUrl);

        navPage.getLanguageSwitchButton().click();
        navPage.getENButtonFromDropDownLanguageMenu().click();
        navPage.getLoginLink().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Url does not contain '/login'");

    }
    @Test(priority = 20)
    public void checksInputTypes(){

        navPage.getLoginLink().click();

        Assert.assertEquals(
                driver.findElement(By.id("email")).getAttribute("type"),
                "email",
                "The element does not contain 'email'.");

        Assert.assertEquals(
                driver.findElement(By.id("password")).getAttribute("type"),
                "password",
                "The element does not contain 'password'.");

    }
    @Test(priority = 30)
    public void displaysErrorsWhenUserDoesNotExist() throws InterruptedException {

        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.getLoginLink().click();
        loginPage.getEmailField().sendKeys(email);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpToBeInvisible();

        Assert.assertTrue(messagePopUpPage.getTextMesage().getText().contains("User does not exists"),
                "The error popup dialog does not contain 'User does not exists'");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Url does not contain '/login'");

    }
    @Test(priority = 40)
    public void displaysErrorsWhenPasswordIsWrong() throws InterruptedException {

    String email = "admin@admin.com";
    String password = "password123";
        navPage.getLoginLink().click();
        loginPage.getEmailField().sendKeys(email);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpToBeInvisible();

        Assert.assertTrue(messagePopUpPage.getTextMesage().getText().contains("Wrong password"),
                "The error popup dialog does not contain 'Wrong password'");
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/login"),
                "Url does not contain '/login'");

    }
    @Test(priority = 50)
    public void login() throws InterruptedException {

        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginLink().click();
        loginPage.getEmailField().sendKeys(email);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getLoginButton().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/home"),
                "Url does not contain '/home'");

    }
    @Test(priority = 60)
    public void logout(){
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(),
                "[ERROR] The element does not visible");

        navPage.getLogoutButton().click();
    }



}
//        Test #1: Visits the login page
//        Koraci:
//        Postaviti EN jezik stranice
//        Klik na login dugme iz navigacije
//        Verifikovati da se u url-u stranice javlja ruta /login
//
//        Test #2: Checks input types
//        Koraci:
//        Klik na login dugme iz navigacije
//        Verifikovati da polje za unos emaila za atribut type ima vrednost email
//        Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//
//        Test #3: Displays errors when user does not exist
//        Podaci:
//        email: non-existing-user@gmal.com
//        password: password123
//        Koraci:
//        Klik na login dugme iz navigacije
//        Popuniti login formu podacima za logovanje
//        Klik na login dugme
//        Sacekati da popu za prikaz greske bude vidljiv
//        Verifikovati da greska sadrzi poruku User does not exists
//        Verifikovati da se u url-u stranice javlja /login ruta
//
//        Test #4: Displays errors when password is wrong
//        Podaci:
//        email: admin@admin.com
//        password: password123
//        Koraci:
//        Klik na login dugme iz navigacije
//        Popuniti login formu podacima za logovanje
//        Klik na login dugme
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da greska sadrzi poruku User does not exists
//        Verifikovati da se u url-u stranice javlja /login ruta
//
//        Test #5: Login
//        Podaci:
//        email: admin@admin.com
//        password: 12345
//        Koraci:
//        Klik na login dugme iz navigacije
//        Popuniti login formu podacima za logovanje
//        Verifikovati da se u url-u stranice javlja /home ruta
//
//
//        Test #6: Logout
//        Koraci:
//        Verifikovati da je dugme logout vidljivo na stranici
//        Kliknuti na logout dugme
