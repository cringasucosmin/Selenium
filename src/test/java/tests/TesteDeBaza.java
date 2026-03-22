package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TesteDeBaza {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Configurăm locația driver-ului și pornim browser-ul
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1, description = "Verifică titlul Google", groups = "Smoke")
    public void testTitluGoogle() {
        driver.get("[https://www.google.com](https://www.google.com)");
        String titlu = driver.getTitle();
        Assert.assertEquals(titlu, "Google", "Titlul paginii nu coincide!");
    }

    @Test(priority = 2, dependsOnMethods = "testTitluGoogle", groups = "Regression")
    public void testVerificareURL() {
        driver.get("[https://www.google.com](https://www.google.com)");
        Assert.assertTrue(driver.getCurrentUrl().contains("google"), "URL-ul este incorect!");
    }
    @Test
    public void testCautareGoogle() {
        driver.get("https://www.google.com");

        // Gasim campul de cautare dupa atributul 'name' (care este "q" la Google)
        // si trimitem textul "QualiAdept" urmat de tasta Enter
        driver.findElement(By.name("q")).sendKeys("QualiAdept" + Keys.ENTER);

        // Verificam daca titlul paginii s-a schimbat dupa cautare
        Assert.assertTrue(driver.getTitle().contains("QualiAdept"));
    }





    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Închide tot și eliberează memoria RAM
        }
    }
}



