package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {

    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton(){
       return driver.findElement(By.className("btnNewItem"));
    }
    public WebElement getSearchField(){
        return driver.findElement(By.id("search"));
    }
    public WebElement getEditButton(){
        return driver.findElement(By.id("edit"));
    }
    public WebElement getEditItemInputField(){
        return driver.findElement(By.xpath("//input[@id ='name']"));
    }
    public void waitToEditDialogShowUp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.className("dlgNewEditItem")));
    }
    public void waitToDeleteDialogShowUp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div/header/div/i")));
    }
    public WebElement getSaveButtonFromEditDialog(){
        return driver.findElement(By.className("btnSave"));
    }
    public WebElement getDeleteButtonFromDeleteDialog(){
        return driver
                .findElement(By.xpath("//div[contains(@class,'v-dialog v-dialog--active')]//button[2]"));
    }
    public void waitForNumberOfRowsToBe(int rowNum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody/tr"), rowNum));
    }
    public WebElement getCellInRow(int rowIndex, int cellIndex) {
        return driver.findElement(By.xpath("//tbody/tr["+rowIndex+"]/td["+cellIndex+"]"));
    }
    public WebElement getDeleteButtonForTheRow(int row){
        return driver.findElement(By.id("delete"));
    }
    public WebElement getNewItemField(){
        return driver.findElement(By.id("name"));
    }
    public WebElement getSaveButtonFromNewItemField(){
        return driver.findElement(By.className("btnSave"));
    }



}
