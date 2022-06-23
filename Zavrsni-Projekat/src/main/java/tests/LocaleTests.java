package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 10)
    public void setLocaleToES(){

        navPage.getLanguageSwitchButton().click();
        navPage.getESButtonFromDropDownLanguageMenu().click();
        Assert.assertTrue(navPage.getHeadingElement().getText().contains("Página de aterrizaje"),
                "Heading element does not contains 'Página de aterrizaje'");
    }
    @Test(priority = 20)
    public void setLocaleToEN(){

        navPage.getLanguageSwitchButton().click();
        navPage.getENButtonFromDropDownLanguageMenu().click();
        Assert.assertTrue(navPage.getHeadingElement().getText().contains("Landing"),
                "Heading element does not contains 'Landing'");
    }
    @Test(priority = 30)
    public void setLocaleToCN(){

        navPage.getLanguageSwitchButton().click();
        navPage.getCNButtonFromDropDownLanguageMenu().click();
        Assert.assertTrue(navPage.getHeadingElement().getText().contains("首页"),
                "Heading element does not contains '首页'");
    }
    @Test(priority = 40)
    public void setLocaleToFR(){

        navPage.getLanguageSwitchButton().click();
        navPage.getFRButtonFromDropDownLanguageMenu().click();
        Assert.assertTrue(navPage.getHeadingElement().getText().contains("Page d'atterrissage"),
                "Heading element does not contains 'Page d'atterrissage'");
    }

}
