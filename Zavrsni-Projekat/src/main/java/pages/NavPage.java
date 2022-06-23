package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {

    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.className("btnHome"));
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.className("btnAbout"));
    }
    public WebElement getLoginLink(){
        return driver.findElement(By.xpath("//div[contains(@class,'v-toolbar__items')]/a[3]"));
    }
    public WebElement getSignUpLink(){
        return driver.findElement(By.xpath("//div[contains(@class,'v-toolbar__items')]/a[4]"));
    }
    public WebElement getMyProfileLink() {
        return driver.findElement(By.className("btnProfile"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesLinkFromDropdownAdminMenu(){
        return driver.findElement(By.className("btnAdminCities"));
    }
    public WebElement getUsersLinkFromDropdownAdminMenu() {
        return driver.findElement(By.className("btnAdminUsers"));
    }
    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }
    public WebElement getLanguageSwitchButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public WebElement getENButtonFromDropDownLanguageMenu(){
        return driver.findElement(By.className("btnEN"));
    }
    public WebElement getESButtonFromDropDownLanguageMenu(){
        return driver.findElement(By.className("btnES"));
    }
    public WebElement getFRButtonFromDropDownLanguageMenu(){
        return driver.findElement(By.className("btnFR"));
    }
    public WebElement getCNButtonFromDropDownLanguageMenu(){
        return driver.findElement(By.className("btnCN"));
    }
    public WebElement getHeadingElement(){
        return driver.findElement(By.xpath("//h1"));
    }

}

