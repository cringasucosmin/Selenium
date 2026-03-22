package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class UserJourneyTests extends BaseTest {
    @Test(groups = {"smoke", "search"})
    public void TestDeCautare() {
        driver.get("https://apps.qualiadept.eu/hapiflix/login.php");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("cringasucosmin", "cosmin123");
        HomePage homePage = new HomePage(driver);
        homePage.goToSearch();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchFor("Friends");
        Assert.assertTrue(searchPage.isResultDisplayed("Friends"));
    }

    @Test(groups = {"regression", "navigation"})
    public void TestDeNavigare(){
        driver.get("https://apps.qualiadept.eu/hapiflix/login.php");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("cringasucosmin", "cosmin123");
        HomePage homePage = new HomePage(driver);
        homePage.goToShows();
        Assert.assertTrue(driver.getCurrentUrl().contains("shows"));

    }
}
