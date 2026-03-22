package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TemaSesiunea3 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup()
    {   driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown()
    {   driver.quit();}
    @Test
    public void testFormularInteligent(){
        driver.get("https://demoqa.com/automation-practice-form");
        //Sincronizare Explicită: Folosește wait.until(ExpectedConditions.visibilityOfElementLocated(...))
        // pentru fiecare câmp de text (First Name, Last Name, Email, Mobile).
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Cosmin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys("Andrei");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).sendKeys("cosmin@qa.ro");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNumber"))).sendKeys("0712345678");
        //Selectare Radio: Alege genul (Male/Female/Other) și validează selecția.
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-radio-1"))).click();
        Assert.assertTrue(driver.findElement(By.id("gender-radio-1")).isSelected());
        //Selectare Checkbox: Bifează cel puțin un Hobby (ex: Sports).
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hobbies-checkbox-2"))).click();
        Assert.assertTrue(driver.findElement(By.id("hobbies-checkbox-2")).isSelected());
      /*  wait.until(ExpectedConditions.elementToBeClickable(By.id("hobbies-checkbox-1"))).click();
        Assert.assertTrue(driver.findElement(By.id("hobbies-checkbox-1")).isSelected());*/
        //Dropdown: Dacă există (ex: State/City), folosește clasa Select sau click-uri secvențiale.
        wait.until(ExpectedConditions.elementToBeClickable(By.id("state"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='NCR']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='city']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Delhi']"))).click();
        //Aserțiune de Final: După click pe „Submit”, așteaptă să apară tabelul de confirmare
        // și verifică dacă textul din header este: "Thanks for submitting the form".
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
        WebElement succes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        Assert.assertTrue(succes.getText().contains("Thanks for submitting the form"));
    }}