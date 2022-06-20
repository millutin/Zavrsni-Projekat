package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

abstract class BasicTest {

    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com/";
    protected CitiesPage citiesPage;
    protected LoginPage loginPage;
    protected MessagePopUpPage messagePopUpPage;
    protected NavPage navPage;
    protected SignupPage signupPage;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        citiesPage = new CitiesPage(driver);
        loginPage = new LoginPage(driver);
        messagePopUpPage = new MessagePopUpPage(driver);
        navPage = new NavPage(driver);
        signupPage = new SignupPage(driver);



    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }
    @AfterMethod
    public void afterMethod(){

    }
    @AfterClass
    public void afterClass(){

        driver.quit();

    }

}
//        Osnovna klasa koju svaki test da nasledjuje. Ova klasa treba da ima:
//        baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
//        beforeClass - gde se podesava drajver sa implicitnim cekanjem
//        i cekanjem za ucitavanje stranice i kreiraju svi pagevi potrebni za testiranje
//        aftterClass - gde se gasi stranica
//        beforeMethod - gde se pre svakog testa ucitava baseUrl stranica
//        (za vezbanje) afterMethod - gde se kreira screenshot stranice u slucaju da test ne prodje
