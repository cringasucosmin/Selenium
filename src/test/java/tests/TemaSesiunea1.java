package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TemaSesiunea1 {

    // Declaram driver-ul - acesta este "telecomanda" browserului
    WebDriver driver;

    // Aceasta metoda ruleaza INAINTE de fiecare test
    @BeforeMethod
    public void deschideBrowserul() {

        // Pornim Chrome
        driver = new ChromeDriver();

        // Maximizam fereastra
        driver.manage().window().maximize();

        System.out.println("Browserul a fost pornit!");
    }

    // Aceasta metoda ruleaza DUPA fiecare test
    @AfterMethod
    public void inchideBrowserul() {
        driver.quit();
        System.out.println("Browserul a fost inchis!");
    }

    // -----------------------------------------------
    // TEST 1: Verificam titlul paginii eMAG
    // -----------------------------------------------
    @Test
    public void testTitluEmag() {

        // Pasul 1: Mergem pe site-ul eMAG
        driver.get("https://www.emag.ro/");
        System.out.println("Am navigat la eMAG");

        // Pasul 2: Citim titlul paginii (ce scrie in tab-ul browserului)
        String titluPaginii = driver.getTitle();
        System.out.println("Titlul gasit este: " + titluPaginii);

        // Pasul 3: Verificam daca titlul este cel asteptat
        Assert.assertEquals(titluPaginii, "eMAG.ro - Căutarea nu se oprește niciodată");

        System.out.println("Test 1 TRECUT! Titlul este corect.");
    }

    // -----------------------------------------------
    // TEST 2: Verificam URL-ul paginii IMDB
    // -----------------------------------------------
    @Test
    public void testUrlImdb() {

        // Pasul 1: Mergem pe site-ul IMDB
        driver.get("https://www.imdb.com/");
        System.out.println("Am navigat la IMDB");

        // Pasul 2: Citim adresa URL curenta din browser
        String urlCurent = driver.getCurrentUrl();
        System.out.println("URL-ul gasit este: " + urlCurent);

        // Pasul 3: Verificam daca URL-ul contine cuvantul "imdb"
        Assert.assertTrue(urlCurent.contains("imdb"));

        System.out.println("Test 2 TRECUT! URL-ul contine 'imdb'.");
    }
}