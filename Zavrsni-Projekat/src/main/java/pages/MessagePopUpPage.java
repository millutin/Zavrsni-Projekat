package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {

    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForDeclinePopUpToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.className("error")));
    }
    public void waitForConfirmPopUpToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.className("success")));
    }
    public WebElement getErrorTextMesage(){
        return driver.findElement(By.xpath("//div[contains(@class,'error')]/div/ul/li"));
    }

    public void waitForVerifyDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.className("dlgVerifyAccount")));
    }
    public WebElement getVerifyPopUp(){
        return driver.findElement(By.className("dlgVerifyAccount"));
    }
    public WebElement getVerifyPopUpCloseButton(){
        return driver.findElement(By.className("btnClose"));
    }
    public WebElement getTextPopUpElement(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]"));
    }

}

