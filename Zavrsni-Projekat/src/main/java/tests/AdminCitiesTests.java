package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 10)
    public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginLink().click();
        loginPage.getEmailField().sendKeys(email);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getLoginButton().click();
        Thread.sleep(3000);
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdownAdminMenu().click();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/admin/cities"),
                "Url does not contains '/admin/cities'");
    }
    @Test(priority = 20)
    public void checksInputTypesForCreateEditNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdownAdminMenu().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitToEditDialogShowUp();
        Assert.assertTrue(citiesPage.getNewItemField().getAttribute("type").contains("text"),
                " Attribute type does not contains text");
    }
    @Test(priority = 30)
    public void createNewCity(){

        String city = "Petar Perovic's city";
        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdownAdminMenu().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitToEditDialogShowUp();
        citiesPage.getNewItemField().sendKeys(city);
        citiesPage.getSaveButtonFromNewItemField().click();
        messagePopUpPage.waitForConfirmPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getTextPopUpElement()
                        .getText()
                        .contains("Saved"),
                "PopUp message does not contains 'Saved successfully' text");

    }
    @Test(priority = 40)
    public void editCity(){

        String oldCityName = "Petar Perovic's city";
        String newCityName = "Marko Markovic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdownAdminMenu().click();
        citiesPage.getSearchField().sendKeys(oldCityName);
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.getEditButton().click();
        citiesPage.getEditItemInputField().sendKeys(Keys.CONTROL,"a");
        citiesPage.getEditItemInputField().sendKeys(newCityName);
        citiesPage.getSaveButtonFromEditDialog().click();
        messagePopUpPage.waitForConfirmPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getTextPopUpElement()
                        .getText()
                        .contains("Saved"),
                "PopUp message does not contains 'Saved successfully' text");

    }
    @Test(priority = 50)
    public void searchCity(){
        String cityName = "Marko Markovic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdownAdminMenu().click();
        citiesPage.getSearchField().sendKeys(cityName);
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertTrue(citiesPage.getCellInRow(1,2).getText().contains(cityName),
                "Name cell does not contains text from the search field");

    }
    @Test(priority = 60)
    public void deleteCity(){

        String cityName = "Marko Markovic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesLinkFromDropdownAdminMenu().click();
        citiesPage.getSearchField().sendKeys(cityName);
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertTrue(citiesPage.getCellInRow(1,2).getText().contains(cityName),
                "Name cell does not contains text from the search field");
        citiesPage.getDeleteButtonForTheRow(1).click();
        citiesPage.waitToDeleteDialogShowUp();
        citiesPage.getDeleteButtonFromDeleteDialog().click();
        messagePopUpPage.waitForConfirmPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getTextPopUpElement().getText().contains("Deleted"),
                "PopUp message does not contains 'Deleted successfully' text");

    }


}
//Test #1: Visits the admin cities page and list cities
//Podaci:
//admin email: admin@admin.com
//admin password: 12345
//Koraci:
//Klik na sign up dugme iz navigacije
//Prijaviti se na sistem admin kredencijalima
//Klik na admin dugme iz navigacije
//Klik na Cities dugme iz padajuceg Admin menija
//Verifikovati da se u url-u stranice javlja /admin/cities ruta
//
//Test #2: Checks input types for create/edit new city
//Koraci:
//Klik na admin dugme iz navigacije
//Klik na Cities dugme iz padajuceg Admin menija
//Kliknuti na New Item dugme
//Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//Verifikovati da polje za unos grada za atribut type ima tekst text
//

//Test #3: Create new city
//Podaci:
//city: [Ime i prezime polaznika]’s city
//Koraci:
//
//Klik na admin dugme iz navigacije
//Klik na Cities dugme iz padajuceg Admin menija
//Kliknuti na New Item dugme
//Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//Uneti ime grada u polje
//Kliknuti na Save dugme
//Sacekati da popu za prikaz poruke bude vidljiv
//Verifikovati da poruka sadrzi tekst Saved successfully
//
//Test #4: Edit city
//Podaci:
//old city name: [Ime i prezime polaznika]’s city
//new city name: [Ime i prezime polaznika]’s city Edited
//Koraci:
//Klik na admin dugme iz navigacije
//Klik na Cities dugme iz padajuceg Admin menija
//U polje za pretragu uneti staro ime grada
//Sacekati da broj redova u tabeli bude 1
//Kliknuti na dugme Edit iz prvog reda
//Uneti novo ime za grad
//Kliknuti na dugme Save
//Sacekati da popu za prikaz poruke bude vidljiv
//Verifikovati da poruka sadrzi tekst Saved successfully
//

//Test #5: Search city
//Podaci:
//city name: [Ime i prezime polaznika]’s city Edited
//Koraci:
//Klik na admin dugme iz navigacije
//Klik na Cities dugme iz padajuceg Admin menija
//U polje za pretragu uneti staro ime grada
//Sacekati da broj redova u tabeli bude 1
//Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
//
//Test #6: Delete city
//Podaci:
//city name: [Ime i prezime polaznika]’s city Edited
//Koraci:
//Klik na admin dugme iz navigacije
//Klik na Cities dugme iz padajuceg Admin menija
//U polje za pretragu uneti staro ime grada
//Sacekati da broj redova u tabeli bude 1
//Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
//Kliknuti na dugme Delete iz prvog reda
//Sacekati da se dijalog za brisanje pojavi
//Kliknuti na dugme Delete iz dijaloga
//Sacekati da popu za prikaz poruke bude vidljiv
//Verifikovati da poruka sadrzi tekst Deleted successfully